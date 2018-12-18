package com.pazz.springboot.mybatis.vo;

/**
 * @author: 彭坚
 * @create: 2018/12/18 22:29
 * @description:
 */
public class TestParamVo {

    private String name;
    private int page;
    private int limit = 200;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
