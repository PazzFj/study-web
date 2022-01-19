package com.pazz.study.rocketmq.configuration;

import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 彭坚
 * @create: 2018/12/3 16:38
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface RocketMQConsumer {

    /**
     * Topic
     */
    String topic();
    /**
     * Tag
     */
    String tag() default "*";
    /**
     * 消费者组
     */
    String consumerGroup();
    /**
     * 消费模式
     */
    MessageModel messageMode() default MessageModel.CLUSTERING;
}
