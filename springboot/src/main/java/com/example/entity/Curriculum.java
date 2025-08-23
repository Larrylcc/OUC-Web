package com.example.entity;

import java.io.Serializable;

/**
 * 课表信息实体类
 * 该类用于表示每周课程安排的信息，包含每一天的课程安排以及课程的时间段。
 * 其中，每一周的每一天（周一至周日）都有可能包含不同的课程安排。
 */
public class Curriculum implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 课程时间段，例如：上午、下午、晚上等 */
    private String segment;

    /** 周一的课程安排 */
    private String monday;

    /** 周二的课程安排 */
    private String tuesday;

    /** 周三的课程安排 */
    private String wednesday;

    /** 周四的课程安排 */
    private String thursday;

    /** 周五的课程安排 */
    private String friday;

    /** 周六的课程安排 */
    private String saturday;

    /** 周日的课程安排 */
    private String sunday;

    /**
     * 获取课程的时间段
     * @return 课程的时间段（如上午、下午等）
     */
    public String getSegment() {
        return segment;
    }

    /**
     * 设置课程的时间段
     * @param segment 课程的时间段（如上午、下午等）
     */
    public void setSegment(String segment) {
        this.segment = segment;
    }

    /**
     * 获取周一的课程安排
     * @return 周一的课程安排，可能是课程名称或空字符串
     */
    public String getMonday() {
        return monday;
    }

    /**
     * 设置周一的课程安排
     * @param monday 周一的课程安排
     */
    public void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * 获取周二的课程安排
     * @return 周二的课程安排，可能是课程名称或空字符串
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * 设置周二的课程安排
     * @param tuesday 周二的课程安排
     */
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * 获取周三的课程安排
     * @return 周三的课程安排，可能是课程名称或空字符串
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * 设置周三的课程安排
     * @param wednesday 周三的课程安排
     */
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * 获取周四的课程安排
     * @return 周四的课程安排，可能是课程名称或空字符串
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * 设置周四的课程安排
     * @param thursday 周四的课程安排
     */
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * 获取周五的课程安排
     * @return 周五的课程安排，可能是课程名称或空字符串
     */
    public String getFriday() {
        return friday;
    }

    /**
     * 设置周五的课程安排
     * @param friday 周五的课程安排
     */
    public void setFriday(String friday) {
        this.friday = friday;
    }

    /**
     * 获取周六的课程安排
     * @return 周六的课程安排，可能是课程名称或空字符串
     */
    public String getSaturday() {
        return saturday;
    }

    /**
     * 设置周六的课程安排
     * @param saturday 周六的课程安排
     */
    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    /**
     * 获取周日的课程安排
     * @return 周日的课程安排，可能是课程名称或空字符串
     */
    public String getSunday() {
        return sunday;
    }

    /**
     * 设置周日的课程安排
     * @param sunday 周日的课程安排
     */
    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
}
