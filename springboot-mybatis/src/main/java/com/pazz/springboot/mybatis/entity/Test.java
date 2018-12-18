package com.pazz.springboot.mybatis.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:29
 * @description:
 */
@Data
@Table(name = "test")
public class Test {

    private int id;
    private String name;
    private String code;
    private Date time;

}
