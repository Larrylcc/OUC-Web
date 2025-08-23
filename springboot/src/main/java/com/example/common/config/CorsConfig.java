package com.example.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 配置跨域请求的相关设置
 * 本配置类允许跨域请求访问所有接口，支持所有源、头部信息及请求方法
 */
@Configuration
public class CorsConfig {

    /**
     * 配置并注册跨域过滤器
     * 此方法返回一个 CorsFilter Bean，定义了跨域策略
     *
     * @return CorsFilter 过滤器实例
     */
    @Bean
    public CorsFilter corsFilter() {
        // 创建跨域配置源对象，负责存储和管理所有跨域配置
        UrlBasedCorsConfigurationSource cors_Source = new UrlBasedCorsConfigurationSource();

        // 创建并配置跨域规则
        CorsConfiguration cors_Config = new CorsConfiguration();

        // 允许任何源进行跨域请求
        cors_Config.addAllowedOrigin("*"); // 允许所有来源进行访问

        // 允许所有请求头
        cors_Config.addAllowedHeader("*"); // 允许所有的请求头部

        // 允许所有HTTP请求方法（如 GET、POST 等）
        cors_Config.addAllowedMethod("*"); // 允许所有请求方式

        // 注册跨域配置，使之对所有接口（/**）生效
        cors_Source.registerCorsConfiguration("/**", cors_Config);

        // 返回跨域过滤器，应用全局跨域配置
        return new CorsFilter(cors_Source);
    }
}
