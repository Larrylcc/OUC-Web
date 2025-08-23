package com.example.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Web配置类，负责配置Spring MVC的拦截器。
 * 主要作用是注册自定义的JWT拦截器，并设置拦截规则。
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtInterceptor jwtInter_ceptor;  // 注入自定义的JWT拦截器

    /**
     * 注册自定义拦截器并配置拦截规则
     *
     * @param reg 拦截器注册对象，用于添加拦截器和设置拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry reg) {
        // 注册jwtInterceptor拦截器，拦截所有请求路径
            reg.addInterceptor(jwtInter_ceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns(getEPaths()); // 排除指定路径
    }

    /**
     * 获取不需要拦截的路径
     *
     * @return 排除的路径列表
     */
    private String[] getEPaths() {
        return new String[] {
                "/",                // 首页
                "/login",           // 登录页
                "/register",        // 注册页
        };
    }
}
