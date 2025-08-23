package com.example.entity;

import java.io.Serializable;

/**
 * 教室安排信息表
 * 用于表示教室安排的详细信息，包括教室ID、名称、状态、人数、内容和所在楼宇等信息。
 */
public class Roomplan implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 教室的唯一标识符 */
    private Integer id;

    /** 教室的名称 */
    private String name;

    /** 教室的使用状态 */
    private String status;

    /** 教室容纳的人数 */
    private Integer renshu;

    /** 教室的安排内容 */
    private String neirong;

    /** 教室所在的楼宇 */
    private String build;

    /**
     * 获取教室所在的楼宇
     * @return 返回教室所在的楼宇名称
     */
    public String getBuild() {
        return build;
    }

    /**
     * 设置教室所在的楼宇
     * @param build 教室所在的楼宇名称
     */
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * 获取教室的唯一标识符
     * @return 返回教室ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置教室的ID
     * @param id 教室的唯一标识符
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取教室的名称
     * @return 返回教室名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置教室的名称
     * @param name 教室名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取教室的使用状态
     * @return 返回教室的状态（如：可用、不可用等）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置教室的使用状态
     * @param status 教室的状态（如：可用、不可用等）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取教室容纳的人数
     * @return 返回教室的容纳人数
     */
    public Integer getRenshu() {
        return renshu;
    }

    /**
     * 设置教室容纳的人数
     * @param renshu 教室的容纳人数
     */
    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    /**
     * 获取教室安排的详细内容
     * @return 返回教室的安排内容
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置教室安排的详细内容
     * @param neirong 教室的安排内容
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
}
