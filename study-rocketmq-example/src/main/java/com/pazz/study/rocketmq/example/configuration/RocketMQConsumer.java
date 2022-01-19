package com.pazz.study.rocketmq.example.configuration;

import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 彭坚
 * @create: 2019/5/16 11:19
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface RocketMQConsumer {

    String consumerGroup();

    String topic();

    String tag() default "*";

    MessageModel messageMode() default MessageModel.CLUSTERING;

}
