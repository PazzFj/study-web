package com.pazz.study.rocketmq.exception;

/**
 * @author: 彭坚
 * @create: 2018/12/3 0:33
 * @description:
 */
public class RocketMQException extends RuntimeException {

    public RocketMQException(String msg) {
        super(msg);
    }

    public RocketMQException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
