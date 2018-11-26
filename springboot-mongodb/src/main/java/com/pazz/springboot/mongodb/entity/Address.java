package com.pazz.springboot.mongodb.entity;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/11/26 15:59
 * @description:
 */
@Data
public class Address {

    /**
     * 编号.
     */
    private String id;
    /**
     * 省.
     */
    private String province;
    /**
     * 市.
     */
    private String city;
    /**
     * 区.
     */
    private String district;
    /**
     * 状态.
     */
    private int status;

    public Address() {
    }

    public Address(String id, String province, String city, String district, int status) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", status=" + status +
                '}';
    }
}
