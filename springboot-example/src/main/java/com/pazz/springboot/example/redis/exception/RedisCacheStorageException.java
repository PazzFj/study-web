package com.pazz.springboot.example.redis.exception;

/**
 * @author: Peng Jian
 * @create: 2018/11/8 10:39
 * @description: 查询参数异常
 */
public class RedisCacheStorageException extends RuntimeException {

    private static final long serialVersionUID = 4189989370221073043L;

    public RedisCacheStorageException(String message) {
        super(message);
    }

    public RedisCacheStorageException(Throwable e) {
        super(e);
    }

    public RedisCacheStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
