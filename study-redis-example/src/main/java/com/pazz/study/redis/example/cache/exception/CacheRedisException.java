package com.pazz.study.redis.example.cache.exception;

public class CacheRedisException extends RuntimeException {

    private static final long serialVersionUID = 135801481185850116L;

    public CacheRedisException(String msg) {
        super(msg);
    }

    public CacheRedisException() {
        super();
    }

    public CacheRedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheRedisException(Throwable cause) {
        super(cause);
    }

}
