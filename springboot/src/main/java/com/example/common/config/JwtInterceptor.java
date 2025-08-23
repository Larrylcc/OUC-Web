package com.example.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.common.Constants;
import com.example.common.enums.ResultCodeEnum;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.exception.CustomException;
import com.example.service.GuanliyuanService;
import com.example.service.XueshengService;
import com.example.service.LaoshiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;

/**
 * Jwt 拦截器，负责验证请求中的JWT token
 * 主要验证token的合法性以及用户信息的有效性
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);

    @Resource
    private GuanliyuanService adminService;

    @Resource
    private  LaoshiService  teacherService;

    @Resource
    private XueshengService studentService;

    // 用户角色到服务的映射
    private Map<String, UserServiceProvider> roleServiceMap;

    /**
     * 在Bean加载后初始化角色和服务的映射关系
     */
    @PostConstruct
    private void initRoleServiceMap() {
        // 初始化角色和服务的映射关系
        roleServiceMap = new HashMap<>();
        roleServiceMap.put(RoleEnum.GUANLIYUAN.name(), id -> adminService.selectById(id));
        roleServiceMap.put(RoleEnum.LAOSHI.name(), id -> teacherService.selectById(id));
        roleServiceMap.put(RoleEnum.XUESHENG.name(), id -> studentService.selectById(id));
    }

    /**
     * 请求处理之前，进行token验证
     *
     * @param request HttpServletRequest 请求对象
     * @param response HttpServletResponse 响应对象
     * @param handler 请求处理器
     * @return boolean 是否继续请求处理
     * @throws CustomException 自定义异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = retrieveTokenFromRequest(request);

        // 如果token为空，抛出异常
        if (ObjectUtil.isEmpty(token)) {
            throw new CustomException(ResultCodeEnum.LINGPAIKONGCUOWU);
        }

        // 解析用户信息
        Account account = authenticateUserFromToken(token);

        // 如果没有找到用户，抛出异常
        if (account == null) {
            throw new CustomException(ResultCodeEnum.YONGHUBUCUNZAI);
        }

        // 校验token的合法性
        verifyTokenWithUserPassword(account.getPassword(), token);

        // 验证通过，允许请求继续执行
        return true;
    }

    /**
     * 从请求中获取token，优先从header获取，如果没有则从请求参数中获取
     *
     * @param request HttpServletRequest 请求对象
     * @return String 获取到的token
     */
    private String retrieveTokenFromRequest(HttpServletRequest request) {
        // 尝试从header获取token
        return ObjectUtil.isEmpty(request.getHeader(Constants.TOKEN)) ?
                request.getParameter(Constants.TOKEN) : request.getHeader(Constants.TOKEN);
    }

    /**
     * 从token中解析出用户的角色和ID，并根据此信息查询数据库
     *
     * @param token JWT token
     * @return Account 用户账户信息
     */
    private Account authenticateUserFromToken(String token) {
        Account account = null;
        try {
            // 解析token中的用户角色和ID
            String[] userParts = JWT.decode(token).getAudience().get(0).split("-");
            String userId = userParts[0];
            String role = userParts[1];

            // 根据角色判断查询对应的用户信息
            account = roleServiceMap.getOrDefault(role, id -> null).getAccount(Integer.valueOf(userId));
        } catch (Exception e) {
            logger.error("Token解析失败，错误信息: {}", e.getMessage());
            throw new CustomException(ResultCodeEnum.LINGOAIJIANCHACUOWU);
        }
        return account;
    }

    /**
     * 使用用户的密码验证token的合法性
     *
     * @param password 用户密码
     * @param token JWT token
     */
    private void verifyTokenWithUserPassword(String password, String token) {
        try {
            // 使用密码对token进行签名验证
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(password)).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            logger.error("Token验证失败，错误信息: {}", e.getMessage());
            throw new CustomException(ResultCodeEnum.LINGOAIJIANCHACUOWU);
        }
    }

    /**
     * 用户服务提供者接口，用于获取用户账户信息
     */
    @FunctionalInterface
    private interface UserServiceProvider {
        Account getAccount(int userId);
    }
}
