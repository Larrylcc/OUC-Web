package com.example.common;
/**
 * Constants 接口包含了常用的常量定义。
 * 这些常量可用于应用程序中的各个地方，避免硬编码字符串。
 */
public interface Constants {
    /**
     * 用于认证的 token 字符串常量
     * 通常用于请求头中的认证令牌。
     */
    String TOKEN = "token";
    /**
     * 默认用户密码常量
     * 新用户注册时默认使用该密码，用户需在首次登录后修改密码。
     */
    String USER_DEFAULT_PASSWORD = "123456";
}
