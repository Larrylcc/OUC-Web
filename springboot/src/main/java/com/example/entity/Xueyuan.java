package com.example.entity;

import java.io.Serializable;

/**
 * 该类代表学院信息表，包含学院的基本信息，如ID、名称以及描述。
 * 该实体类用于存储和传输学院相关数据。
 */
public class Xueyuan implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 学院ID，唯一标识每个学院 */
    private Integer id;

    /** 学院名称，用于标识学院的名称 */
    private String name;

    /** 学院描述，包含关于学院的其他信息 */
    private String neirong;

    /**
     * 获取学院ID
     * @return 学院的ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置学院ID
     * @param id 学院的唯一标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学院名称
     * @return 学院的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学院名称
     * @param name 学院名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学院的描述信息
     * @return 学院描述
     */
    public String getNeirong() {
        return neirong;
    }

    /**
     * 设置学院的描述信息
     * @param neirong 学院的相关描述
     */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
}
