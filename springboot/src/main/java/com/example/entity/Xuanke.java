package com.example.entity;

import java.io.Serializable;

/**
 * 选课信息表类，用于表示学生、教师和课程之间的选课关系
 */
public class Xuanke implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 选课记录的唯一ID */
    private Integer id;

    /** 关联教师的ID */
    private Integer teacherId;

    /** 关联学生的ID */
    private Integer studentId;

    /** 关联课程的ID */
    private Integer courseId;

    /** 课程成绩 */
    private Integer scorec;

    /** 课程名称 */
    private String name;

    /** 课程类型（如：必修、选修等） */
    private String type;

    /** 课程的学分 */
    private Integer xuefen;

    /** 课程最大人数 */
    private Integer renshu;

    /** 课程上课地点 */
    private String jiaoshi;

    /** 上课周次 */
    private String xingqi;

    /** 上课时段 */
    private String segment;

    /** 选课状态（如：已选、待确认、已完成等） */
    private String status;

    /** 教师名称 */
    private String jiaoshimingcheng;

    /** 学生姓名 */
    private String xueshengxingcheng;

    // Getter and Setter Methods

    /**
     * 获取选课记录ID
     * @return 返回选课记录的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置选课记录ID
     * @param id 选课记录的ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程成绩
     * @return 返回课程成绩
     */
    public Integer getScorec() {
        return scorec;
    }

    /**
     * 设置课程成绩
     * @param scorec 课程成绩
     */
    public void setScorec(Integer scorec) {
        this.scorec = scorec;
    }

    /**
     * 获取课程名称
     * @return 返回课程名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置课程名称
     * @param name 课程名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取课程类型
     * @return 返回课程类型（如：必修、选修等）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置课程类型
     * @param type 课程类型（如：必修、选修等）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取教师ID
     * @return 返回教师的ID
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师ID
     * @param teacherId 教师的ID
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取课程学分
     * @return 返回课程学分
     */
    public Integer getXuefen() {
        return xuefen;
    }

    /**
     * 设置课程学分
     * @param xuefen 课程学分
     */
    public void setXuefen(Integer xuefen) {
        this.xuefen = xuefen;
    }

    /**
     * 获取课程最大人数
     * @return 返回课程的最大人数
     */
    public Integer getRenshu() {
        return renshu;
    }

    /**
     * 设置课程最大人数
     * @param renshu 课程最大人数
     */
    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    /**
     * 获取上课地点
     * @return 返回课程上课的地点
     */
    public String getJiaoshi() {
        return jiaoshi;
    }

    /**
     * 设置上课地点
     * @param jiaoshi 课程上课地点
     */
    public void setJiaoshi(String jiaoshi) {
        this.jiaoshi = jiaoshi;
    }

    /**
     * 获取上课的周次
     * @return 返回课程上课的周次
     */
    public String getXingqi() {
        return xingqi;
    }

    /**
     * 设置上课周次
     * @param xingqi 课程上课周次
     */
    public void setXingqi(String xingqi) {
        this.xingqi = xingqi;
    }

    /**
     * 获取上课时段
     * @return 返回课程上课的时段
     */
    public String getSegment() {
        return segment;
    }

    /**
     * 设置上课时段
     * @param segment 课程上课时段
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /**
     * 获取选课状态
     * @return 返回选课状态（如：已选、待确认、已完成等）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置选课状态
     * @param status 选课状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取教师姓名
     * @return 返回教师姓名
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
     * 获取学生ID
     * @return 返回学生ID
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 设置学生ID
     * @param studentId 学生ID
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取学生姓名
     * @return 返回学生姓名
     */
    public String getXueshengxingcheng() {
        return xueshengxingcheng;
    }

    /**
     * 设置学生姓名
     * @param xueshengxingcheng 学生姓名
     */
    public void setXueshengxingcheng(String xueshengxingcheng) {
        this.xueshengxingcheng = xueshengxingcheng;
    }

    /**
     * 获取课程ID
     * @return 返回课程ID
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 设置课程ID
     * @param courseId 课程ID
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
