package com.example.entity;

import java.io.Serializable;

/**
 * 该类代表评教信息表，用于存储关于学生对教师的评价信息。
 * 包含评教的基本信息，如ID、课程名称、教师、学生、评论内容和评论时间。
 */
public class Pingjia implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 评教记录的唯一标识符 */
    private Integer id;

    /** 课程名称，表示该课程的名称 */
    private String name;

    /** 教师姓名，表示被评价的教师 */
    private String laoshi;

    /** 学生姓名，表示进行评教的学生 */
    private String xuesheng;

    /** 评教内容，包含学生对教师的评价 */
    private String neirong;

    /** 评教时间，记录评论的时间 */
    private String time;

    /**
     * 获取评教记录的唯一ID
     * @return 评教记录的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置评教记录的唯一ID
     * @param id 评教记录的唯一标识符
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取课程名称
     * @return 课程名称
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
     * 获取教师姓名
     * @return 教师姓名
     */
    public String getLaoshi() {
        return laoshi;
    }

    /**
     * 设置教师姓名
     * @param laoshi 被评教的教师姓名
     */
    public void setLaoshi(String laoshi) {
        this.laoshi = laoshi;
    }

    /**
     * 获取学生姓名
     * @return 学生姓名
     */
    public String getXuesheng() {
        return xuesheng;
    }

    /**
     * 设置学生姓名
     * @param xuesheng 进行评教的学生姓名
     */
    public void setXuesheng(String xuesheng) {
        this.xuesheng = xuesheng;
    }

    /**
     * 获取评教的时间
     * @return 评教时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置评教的时间
     * @param time 评教发生的时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取评教内容
     * @return 评教内容
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置评教内容
     * @param neirong 学生对教师的评价内容
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
}
