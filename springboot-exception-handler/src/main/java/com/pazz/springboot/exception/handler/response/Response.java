package com.pazz.springboot.exception.handler.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回实体<T>
 * @author 彭坚
 * @create 2018/8/23 20:31
 * @see Response
 */
@Data
public class Response<T> implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 是否业务异常
     */
    private boolean businessException;
    /**
     * 状态码
     */
    private String errorCode;
    /**
     * 信息
     */
    private String message;
    /**
     * 返回结果
     */
    private T result;

}
