package com.example.entity;

import java.io.Serializable;

/**
 * 学生实体类，继承自Account类，表示学生用户的相关信息。
 * 包括学生的ID、用户名、密码、个人信息、所属学院、专业、班级、分数等。
 */
public class Xuesheng extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 学生的唯一标识符 */
    private Integer id;

    /** 学生的用户名 */
    private String username;

    /** 学生的登录密码 */
    private String password;

    /** 学生的真实姓名 */
    private String name;

    /** 学生的头像 */
    private String avatar;

    /** 学生的角色类型 */
    private String role;

    /** 学生所属学院的ID */
    private Integer collegeId;

    /** 学生所属专业的ID */
    private Integer specialityId;

    /** 学生所属班级的ID */
    private Integer classId;

    /** 学生的学业分数 */
    private Integer xuefen;

    /** 学院名称 */
    private String collegeName;

    /** 专业名称 */
    private String specialitymingcheng;

    /** 班级名称 */
    private String className;

    // --- 以下是从Account类继承的方法 --- //

    /**
     * 获取学生的唯一ID
     * @return 返回学生的ID
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * 设置学生的唯一ID
     * @param id 学生的ID
     */
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学生的用户名
     * @return 返回学生的用户名
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 设置学生的用户名
     * @param username 学生的用户名
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取学生的登录密码
     * @return 返回学生的密码
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 设置学生的登录密码
     * @param password 学生的密码
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取学生的姓名
     * @return 返回学生的真实姓名
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 设置学生的姓名
     * @param name 学生的真实姓名
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学生的头像
     * @return 返回学生的头像URL
     */
    @Override
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置学生的头像
     * @param avatar 学生的头像URL
     */
    @Override
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取学生的角色
     * @return 返回学生的角色（如：学生、管理员等）
     */
    @Override
    public String getRole() {
        return role;
    }

    /**
     * 设置学生的角色
     * @param role 学生的角色
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    // --- 以下是学生特有的属性 --- //

    /**
     * 获取学生所属学院的ID
     * @return 返回学生所属学院的ID
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * 设置学生所属学院的ID
     * @param collegeId 学生所属学院的ID
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * 获取学生所属专业的ID
     * @return 返回学生所属专业的ID
     */
    public Integer getSpecialityId() {
        return specialityId;
    }

    /**
     * 设置学生所属专业的ID
     * @param specialityId 学生所属专业的ID
     */
    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    /**
     * 获取学生所属班级的ID
     * @return 返回学生所属班级的ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置学生所属班级的ID
     * @param classId 学生所属班级的ID
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取学生所属学院的名称
     * @return 返回学院名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学生所属学院的名称
     * @param collegeName 学院名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 获取学生所属专业的名称
     * @return 返回专业名称
     */
    public String getZhuanyemingcheng() {
        return specialitymingcheng;
    }

    /**
     * 设置学生所属专业的名称
     * @param specialitymingcheng 专业名称
     */
    public void setZhuanyemingcheng(String specialitymingcheng) {
        this.specialitymingcheng = specialitymingcheng;
    }

    /**
     * 获取学生所属班级的名称
     * @return 返回班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置学生所属班级的名称
     * @param className 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取学生的学业分数
     * @return 返回学生的分数
     */
    public Integer getXuefen() {
        return xuefen;
    }

    /**
     * 设置学生的学业分数
     * @param xuefen 学生的分数
     */
    public void setXuefen(Integer xuefen) {
        this.xuefen = xuefen;
    }
}
