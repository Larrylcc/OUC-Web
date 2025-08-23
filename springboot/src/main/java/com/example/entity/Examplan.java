package com.example.entity;

import java.io.Serializable;

/**
 * 考试安排表实体类
 * 此类用于表示考试安排的基本信息，包括考试的ID、名称、内容以及时间。
 * 每个考试安排都包含以下属性：ID（唯一标识）、名称、内容描述和时间。
 */
public class Examplan implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 考试唯一标识符 */
    private Integer id;

    /** 考试名称，例如：数学期末考试 */
    private String name;

    /** 考试内容描述，详细说明考试涉及的知识点 */
    private String neirong;

    /** 考试时间，表示考试的具体日期和时间 */
    private String time;

    /**
     * 获取考试的唯一标识符
     * @return 返回考试的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置考试的唯一标识符
     * @param id 考试的ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取考试的名称
     * @return 返回考试的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置考试的名称
     * @param name 考试的名称，例如：数学期末考试
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取考试的内容描述
     * @return 返回考试内容的详细描述
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置考试的内容描述
     * @param neirong 考试的内容描述，通常包括考试的知识点或其他相关信息
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    /**
     * 获取考试的时间
     * @return 返回考试的具体时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置考试的时间
     * @param time 考试的时间，格式为“YYYY-MM-DD HH:mm”
     */
    public void setTime(String time) {
        this.time = time;
    }
}
