package com.pazz.springboot.exception.handler.response;

import lombok.Data;

/**
 * 返回结果集实体
 * @author 彭坚
 * @create 2018/8/23 20:34
 * @see PageResponse
 */
@Data
public class PageResponse<T> extends Response {
    /**
     * 总数
     */
    private long totalCount;

}
