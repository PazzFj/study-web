package com.pazz.springboot.mybatis.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 彭坚
 * @create: 2018/12/18 22:09
 * @description:
 */
@Data
public class PageResponse<T> implements Serializable {

    private long totalCount;

    /**
     * 返回结果
     */
    private T result;

    public PageResponse(long totalCount, T result) {
        this.totalCount = totalCount;
        this.result = result;
    }

}
