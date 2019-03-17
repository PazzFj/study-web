package com.pazz.springboot.mybatis.vo;

import lombok.Data;

/**
 * @author: 彭坚
 * @create: 2018/12/18 22:29
 * @description:
 */
@Data
public class TestParamVo {

    private String name;
    private int page = 1;
    private int limit = 20;

}
