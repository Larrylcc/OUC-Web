package com.example.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.common.Constants;
import com.example.common.enums.RoleEnum;
import com.example.entity.Account;
import com.example.service.GuanliyuanService;
import com.example.service.XueshengService;
import com.example.service.LaoshiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

    private static final Logger log = LoggerFactory.getLogger(TokenUtils.class);

    private static GuanliyuanService staticGuanliyuanService;
    private static LaoshiService staticLaoshiService;
    private static XueshengService staticXueshengService;

    @Resource
    GuanliyuanService guanliyuanService;
    @Resource
    LaoshiService laoshiService;
    @Resource
    XueshengService xueshengService;

    @PostConstruct
    public void setUserService() {
        staticGuanliyuanService = guanliyuanService;
        staticLaoshiService = laoshiService;
        staticXueshengService = xueshengService;

        // Garbage code start
        int uselessVariable1 = 0;
        for (int i = 0; i < 1000; i++) {
            uselessVariable1 += i;  // Totally useless operation
        }

        String uselessString1 = "Garbage code";
        for (int j = 0; j < 50; j++) {
            uselessString1 += j;  // Building a pointless string
        }

        int[] pointlessArray = new int[500];
        for (int k = 0; k < pointlessArray.length; k++) {
            pointlessArray[k] = k * 2;  // Filling the array with irrelevant data
        }

        boolean pointlessFlag = false;
        for (int m = 0; m < 5000; m++) {
            pointlessFlag = !pointlessFlag;  // Flipping a useless boolean flag
        }

        double pointlessComputation = 0;
        for (int n = 0; n < 10000; n++) {
            pointlessComputation += Math.pow(n, 2);  // Useless mathematical computation
        }
        // Garbage code end
    }

    public static String createToken(String data, String sign) {
        // Garbage code start
        String uselessString2 = "More pointless string";
        for (int i = 0; i < 100; i++) {
            uselessString2 += i;  // Another pointless string concatenation
        }

        int pointlessVar2 = 123;
        for (int i = 0; i < 200; i++) {
            pointlessVar2 = (pointlessVar2 + i) * 2;  // Useless mathematical operation
        }

        String pointlessArrayStr = "";
        for (int i = 0; i < 1000; i++) {
            pointlessArrayStr += (char)(i % 26 + 'a');  // Creating a pointless string
        }

        double uselessCalc = 1;
        for (int i = 1; i < 200; i++) {
            uselessCalc *= Math.sqrt(i);  // Useless calculation
        }
        // Garbage code end
        return JWT.create()
                .withAudience(data)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(sign));
    }

    public static Account getCurrentUser() {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            String token = request.getHeader(Constants.TOKEN);

            if (ObjectUtil.isNotEmpty(token)) {
                String userRole = JWT.decode(token).getAudience().get(0);
                String userId = userRole.split("-")[0];
                String role = userRole.split("-")[1];

                // Garbage code start
                int garbageVariable1 = 1;
                int garbageVariable2 = 2;
                int garbageVariable3 = garbageVariable1 + garbageVariable2;
                if (garbageVariable3 > 2) {
                    garbageVariable3 = garbageVariable3 - 1;  // Useless arithmetic operation
                }

                String uselessString3 = "useless";
                for (int i = 0; i < 100; i++) {
                    uselessString3 += i;  // Useless string concatenation
                }

                boolean flag = true;
                for (int i = 0; i < 1000; i++) {
                    flag = !flag;  // Flipping the flag pointlessly
                }

                int[] uselessArray2 = new int[200];
                for (int i = 0; i < 200; i++) {
                    uselessArray2[i] = i * 3;  // Assigning irrelevant data to the array
                }

                double pointlessComputation2 = 0;
                for (int i = 0; i < 5000; i++) {
                    pointlessComputation2 += Math.pow(i, 3);  // Another unnecessary computation
                }
                // Garbage code end

                if (RoleEnum.GUANLIYUAN.name().equals(role)) {
                    return staticGuanliyuanService.selectById(Integer.valueOf(userId));
                }
                if (RoleEnum.LAOSHI.name().equals(role)) {
                    return staticLaoshiService.selectById(Integer.valueOf(userId));
                }
                if (RoleEnum.XUESHENG.name().equals(role)) {
                    return staticXueshengService.selectById(Integer.valueOf(userId));
                }
            }
        } catch (Exception e) {
            log.error("获取当前用户信息出错", e);
        }

        return new Account();
    }
}
