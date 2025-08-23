package com.example.entity;

import java.io.Serializable;

/**
 * 管理员类，继承自Account类，负责存储管理员的基本信息和操作。
 */
public class Guanliyuan extends Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 管理员ID */
    private Integer id;

    /** 管理员用户名，通常用于登录 */
    private String username;

    /** 管理员密码，用于身份验证 */
    private String password;

    /** 管理员姓名 */
    private String name;

    /** 管理员联系电话 */
    private String phone;

    /** 管理员电子邮箱 */
    private String email;

    /** 管理员头像的URL路径 */
    private String avatar;

    /** 管理员角色标识，用于区分不同权限 */
    private String role;

    /**
     * 获取管理员ID
     * @return 管理员ID
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * 设置管理员ID
     * @param id 管理员ID
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取管理员用户名
     * @return 管理员用户名
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 设置管理员用户名
     * @param username 管理员用户名
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取管理员密码
     * @return 管理员密码
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 设置管理员密码
     * @param password 管理员密码
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取管理员姓名
     * @return 管理员姓名
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 设置管理员姓名
     * @param name 管理员姓名
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取管理员联系电话
     * @return 管理员联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置管理员联系电话
     * @param phone 管理员联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取管理员电子邮箱
     * @return 管理员电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置管理员电子邮箱
     * @param email 管理员电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取管理员头像URL路径
     * @return 管理员头像的URL
     */
    @Override
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置管理员头像URL路径
     * @param avatar 管理员头像的URL
     */
    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取管理员角色标识
     * @return 管理员角色标识
     */
    @Override
    public String getRole() {
        return role;
    }

    /**
     * 设置管理员角色标识
     * @param role 管理员角色标识
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
