package com.example.entity;

import java.io.Serializable;

/**
 * 公告信息实体类
 * 此类用于表示公告的详细信息，包括公告的ID、标题、内容、创建时间以及创建人。
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 公告的唯一标识符 */
    private Integer id;

    /** 公告的标题 */
    private String title;

    /** 公告的具体内容 */
    private String neirong;

    /** 公告的创建时间 */
    private String time;

    /** 公告的创建人 */
    private String user;

    /**
     * 获取公告的唯一标识符
     * @return 返回公告的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置公告的ID
     * @param id 公告的唯一标识符
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取公告的标题
     * @return 返回公告的标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置公告的标题
     * @param title 公告的标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取公告的内容
     * @return 返回公告的具体内容
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置公告的内容
     * @param neirong 公告的详细内容
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

    /**
     * 获取公告的创建时间
     * @return 返回公告的创建时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置公告的创建时间
     * @param time 公告的创建时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取公告的创建人
     * @return 返回公告的创建者姓名
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置公告的创建人
     * @param user 公告的创建人姓名
     */
    public void setUser(String user) {
        this.user = user;
    }
}
