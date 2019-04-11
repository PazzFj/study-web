package com.pazz.springboot.redis.example.cache.exception;

/**
 * @author: Peng Jian
 * @create: 2018/11/7 14:23
 * @description: 缓存配置异常
 */
public class CacheConfigException extends RuntimeException {

    private static final long serialVersionUID = 135801481185850116L;

    public CacheConfigException(String msg) {
        super(msg);
    }
}
