package com.pazz.springboot.redis.exception;

public class CacheConfigException extends GeneralException {

    private static final long serialVersionUID = 135801481185850116L;

    public CacheConfigException(String msg) {
        super(msg);
    }
}
