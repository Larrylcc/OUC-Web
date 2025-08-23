package com.example.entity;

import java.io.Serializable;

/**
 * 专业信息类，用于存储专业相关信息。
 * 包括专业ID、名称、内容、所属学院、学院名称以及相关分数等。
 */
public class Speciality implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 专业的唯一标识符 */
    private Integer id;

    /** 专业名称 */
    private String name;

    /** 专业的详细介绍 */
    private String neirong;

    /** 所属学院的ID */
    private Integer collegeId;

    /** 专业的评分或分数 */
    private Integer xuefen;

    /** 学院名称 */
    private String collegeName;

    /**
     * 获取专业ID
     * @return 返回专业的唯一标识符
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置专业ID
     * @param id 专业的唯一标识符
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取专业名称
     * @return 返回专业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置专业名称
     * @param name 专业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取专业介绍
     * @return 返回专业的详细内容
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置专业介绍
     * @param neirong 专业的详细介绍
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    /**
     * 获取学院ID
     * @return 返回所属学院的ID
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * 设置学院ID
     * @param collegeId 学院的唯一标识符
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * 获取专业评分或分数
     * @return 返回专业评分或分数
     */
    public Integer getXuefen() {
        return xuefen;
    }

    /**
     * 设置专业评分或分数
     * @param xuefen 专业评分或分数
     */
    public void setXuefen(Integer xuefen) {
        this.xuefen = xuefen;
    }

    /**
     * 获取学院名称
     * @return 返回学院名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学院名称
     * @param collegeName 学院名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
