package com.example.entity;

/**
 * 角色用户父类，定义了用户账户的一些基本信息和操作。
 */
public class Account {

    /** 用户唯一标识 */
    private Integer id;

    /** 用户名，用于登录 */
    private String username;

    /** 用户显示名称 */
    private String name;

    /** 用户的密码 */
    private String password;

    /** 用户角色标识符，用于区分不同权限的角色 */
    private String role;

    /** 用户的新密码，通常用于修改密码 */
    private String newPassword;

    /** 用户头像的URL路径 */
    private String avatar;

    /** 用于身份验证的token */
    private String token;

    /**
     * 获取用户ID
     * @return 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     * @return 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户的显示名称
     * @return 用户名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户的显示名称
     * @param name 用户名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户密码
     * @return 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户角色
     * @return 角色标识
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置用户角色
     * @param role 用户角色标识
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * 获取用户的新密码
     * @return 新密码
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * 设置用户的新密码
     * @param newPassword 新密码
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * 获取用户头像
     * @return 头像URL路径
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     * @param avatar 头像URL路径
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取用户的身份验证Token
     * @return Token值
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置用户的身份验证Token
     * @param token 身份验证Token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
