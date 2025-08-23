package com.example.entity;

import java.io.Serializable;

/**
 * 课程信息表实体类，包含课程的基本信息。
 * 此类用于表示课程的属性，如课程ID、名称、类型、授课教师、学分、上课人数、上课地点、周次、时间段及课程状态等。
 */
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 课程ID，唯一标识每一门课程 */
    private Integer id;

    /** 课程名称 */
    private String name;

    /** 课程类型，例如：必修、选修等 */
    private String type;

    /** 教师ID，指向教师的唯一标识 */
    private Integer teacherId;

    /** 课程的学分 */
    private Integer xuefen;

    /** 课程的上课人数 */
    private Integer renshu;

    /** 上课教室 */
    private String jiaoshi;

    /** 上课的星期几，通常用数字表示，如1代表周一 */
    private String xingqi;

    /** 上课的时间段，例如：上午第一节，下午第二节等 */
    private String segment;

    /** 课程状态，表示课程的当前状态，如“已开课”、“未开课”等 */
    private String status;

    /** 教师姓名，用于显示教师的名字 */
    private String jiaoshimingcheng;

    /**
     * 获取课程ID
     * @return 课程的唯一标识符
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置课程ID
     * @param id 课程的唯一标识符
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程名称
     * @return 课程的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     * @param name 课程的名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程类型
     * @return 课程类型，如必修、选修等
     */
    public String getType() {
        return type;
    }

    /**
     * 设置课程类型
     * @param type 课程的类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取教师ID
     * @return 教师的唯一标识符
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师ID
     * @param teacherId 教师的唯一标识符
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取课程的学分
     * @return 课程的学分
     */
    public Integer getXuefen() {
        return xuefen;
    }

    /**
     * 设置课程的学分
     * @param xuefen 课程的学分
     */
    public void setXuefen(Integer xuefen) {
        this.xuefen = xuefen;
    }

    /**
     * 获取课程的上课人数
     * @return 课程的上课人数
     */
    public Integer getRenshu() {
        return renshu;
    }

    /**
     * 设置课程的上课人数
     * @param renshu 课程的上课人数
     */
    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    /**
     * 获取上课教室
     * @return 上课的教室
     */
    public String getJiaoshi() {
        return jiaoshi;
    }

    /**
     * 设置上课教室
     * @param jiaoshi 上课教室
     */
    public void setJiaoshi(String jiaoshi) {
        this.jiaoshi = jiaoshi;
    }

    /**
     * 获取课程的上课星期
     * @return 上课的星期，通常用数字表示，如1表示周一
     */
    public String getXingqi() {
        return xingqi;
    }

    /**
     * 设置课程的上课星期
     * @param xingqi 课程上课的星期
     */
    public void setXingqi(String xingqi) {
        this.xingqi = xingqi;
    }

    /**
     * 获取课程的时间段
     * @return 课程的时间段
     */
    public String getSegment() {
        return segment;
    }

    /**
     * 设置课程的时间段
     * @param segment 课程的时间段
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /**
     * 获取课程状态
     * @return 课程的状态（例如“已开课”、“未开课”）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置课程状态
     * @param status 课程的状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取教师姓名
     * @return 教师的姓名
     */
    public String getJiaoshimingcheng() {
        return jiaoshimingcheng;
    }

    /**
     * 设置教师姓名
     * @param jiaoshimingcheng 教师的姓名
     */
    public void setJiaoshimingcheng(String jiaoshimingcheng) {
        this.jiaoshimingcheng = jiaoshimingcheng;
    }
}
