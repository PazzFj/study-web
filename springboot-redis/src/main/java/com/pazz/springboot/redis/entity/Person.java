package com.pazz.springboot.redis.entity;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/11/28 0:47
 * @description:
 */
@Data
public class Person {

    private int pid;
    private String pName;
    private String psex;
    private int pAge;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", psex='" + psex + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
