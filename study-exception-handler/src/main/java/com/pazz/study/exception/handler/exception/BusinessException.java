package com.pazz.study.exception.handler.exception;

import java.io.Serializable;

/**
 * @author: 彭坚
 * @create: 2018/11/22 14:08
 * @description:
 */
public class BusinessException extends RuntimeException implements Serializable {

    protected String errCode;
    private String nativeMsg;
    private Object[] arguments;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.errCode = code;
    }

    public BusinessException(String code, String msg, Throwable cause) {
        super(msg, cause);
        this.errCode = code;
    }

    public BusinessException(String code, String msg, String nativeMsg) {
        super(msg);
        this.errCode = code;
        this.nativeMsg = nativeMsg;
    }

    public BusinessException(String code, String msg, String nativeMsg,
                             Throwable cause) {
        super(msg, cause);
        this.errCode = code;
        this.nativeMsg = nativeMsg;
    }

    public BusinessException(String code, Object... args) {
        this.errCode = code;
        this.arguments = args;
    }

    public BusinessException(String code, String msg, Object... args) {
        super(msg);
        this.errCode = code;
        this.arguments = args;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public String getErrorCode() {
        return errCode;
    }

    public String getNativeMsg() {
        return nativeMsg;
    }

    public Object[] getArguments() {
        return arguments;
    }

}
