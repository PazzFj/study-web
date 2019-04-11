package com.pazz.springboot.redis.example.exception;

/**
 * @author: 彭坚
 * @create: 2019/4/11 16:27
 * @description:
 */
public class PersonException extends RuntimeException {

    public PersonException() {
    }

    public PersonException(String message) {
        super(message);
    }
}
