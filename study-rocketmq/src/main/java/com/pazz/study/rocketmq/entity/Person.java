package com.pazz.study.rocketmq.entity;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:36
 * @description:
 */
@Data
public class Person {

    private int pId;

    private String pName;

    private String pSex;

    private int pAge;

    public Person() {
    }

    public Person(int pId, String pName, String pSex, int pAge) {
        this.pId = pId;
        this.pName = pName;
        this.pSex = pSex;
        this.pAge = pAge;
    }


}
