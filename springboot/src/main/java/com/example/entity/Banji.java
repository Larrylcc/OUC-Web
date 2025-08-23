package com.example.entity;

import java.io.Serializable;

/**
 * 班级信息表类，代表一个班级及其相关属性，如班级名称、教师和专业信息
 */
public class Banji implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 班级ID */
    private Integer id;

    /** 班级名称 */
    private String name;

    /** 班级描述 */
    private String neirong;

    /** 班级所对应的教师ID */
    private Integer teacherId;

    /** 班级所对应的专业ID */
    private Integer specialityId;

    /** 班级的教师姓名 */
    private String jiaoshimingcheng;

    /** 班级所对应的专业名称 */
    private String specialitymingcheng;

    // Getter and Setter Methods

    /**
     * 获取班级ID
     * @return 班级的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置班级ID
     * @param id 班级ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取班级名称
     * @return 班级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置班级名称
     * @param name 班级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取班级描述
     * @return 班级描述
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置班级描述
     * @param neirong 班级描述
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    /**
     * 获取班级所对应的教师ID
     * @return 教师ID
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置班级所对应的教师ID
     * @param teacherId 教师ID
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取班级所对应的专业ID
     * @return 专业ID
     */
    public Integer getSpecialityId() {
        return specialityId;
    }

    /**
     * 设置班级所对应的专业ID
     * @param specialityId 专业ID
     */
    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    /**
     * 获取教师姓名
     * @return 教师姓名
     */
    public String getJiaoshimingcheng() {
        return jiaoshimingcheng;
    }

    /**
     * 设置教师姓名
     * @param jiaoshimingcheng 教师姓名
     */
    public void setJiaoshimingcheng(String jiaoshimingcheng) {
        this.jiaoshimingcheng = jiaoshimingcheng;
    }

    /**
     * 获取专业名称
     * @return 专业名称
     */
    public String getZhuanyemingcheng() {
        return specialitymingcheng;
    }

    /**
     * 设置专业名称
     * @param specialitymingcheng 专业名称
     */
    public void setZhuanyemingcheng(String specialitymingcheng) {
        this.specialitymingcheng = specialitymingcheng;
    }
}
