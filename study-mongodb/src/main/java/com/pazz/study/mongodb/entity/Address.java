package com.pazz.study.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author: 彭坚
 * @create: 2018/11/26 15:59
 * @description:
 */
@Data
@Document(collection = "Address")
public class Address {

    /**
     * id.
     */
    @Id
    private String id;
    /**
     * 编号.
     */
    private String number;
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
