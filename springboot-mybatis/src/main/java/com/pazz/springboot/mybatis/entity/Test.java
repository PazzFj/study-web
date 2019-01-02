package com.pazz.springboot.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;

}
