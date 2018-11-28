package com.pazz.springboot.redis.exception;

/**
 * @author: Peng Jian
 * @create: 2018/11/7 14:26
 * @description: key存在，value为null
 */
public class ValueIsNullException extends RuntimeException {

    private static final long serialVersionUID = 9035085457927187841L;

    public ValueIsNullException(String msg) {
        super(msg);
    }
}
