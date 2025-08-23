package com.example.entity;

import java.io.Serializable;

/**
 * 教师实体类，继承自Account类，表示教师的相关信息。
 * 包含教师的ID、用户名、密码、个人信息、联系方式以及职称等。
 */
public class Laoshi extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 教师的唯一标识符 */
    private Integer id;

    /** 教师的用户名 */
    private String username;

    /** 教师的登录密码 */
    private String password;

    /** 教师的姓名 */
    private String name;

    /** 教师的头像 */
    private String avatar;

    /** 教师的角色（如：教师、管理员等） */
    private String role;

    /** 教师的联系电话 */
    private String phone;

    /** 教师的电子邮件地址 */
    private String email;

    /** 教师的职称 */
    private String title;

    // --- 以下是继承自Account类的方法 --- //

    /**
     * 获取教师的唯一ID
     * @return 返回教师的ID
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * 设置教师的唯一ID
     * @param id 教师的ID
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取教师的用户名
     * @return 返回教师的用户名
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 设置教师的用户名
     * @param username 教师的用户名
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取教师的登录密码
     * @return 返回教师的密码
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 设置教师的登录密码
     * @param password 教师的密码
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取教师的姓名
     * @return 返回教师的姓名
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 设置教师的姓名
     * @param name 教师的姓名
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取教师的头像
     * @return 返回教师的头像URL
     */
    @Override
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置教师的头像
     * @param avatar 教师的头像URL
     */
    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取教师的角色
     * @return 返回教师的角色（如：教师、管理员等）
     */
    @Override
    public String getRole() {
        return role;
    }

    /**
     * 设置教师的角色
     * @param role 教师的角色
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    // --- 以下是教师特有的属性 --- //

    /**
     * 获取教师的联系电话
     * @return 返回教师的联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置教师的联系电话
     * @param phone 教师的联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取教师的电子邮件
     * @return 返回教师的电子邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置教师的电子邮件
     * @param email 教师的电子邮件地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取教师的职称
     * @return 返回教师的职称（如：讲师、副教授、教授等）
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置教师的职称
     * @param title 教师的职称
     */
    public void setTitle(String title) {
        this.title = title;
    }
}
