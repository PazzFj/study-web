package com.pazz.springboot.rocketmq.example.configuration;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 彭坚
 * @create: 2019/5/16 11:15
 * @description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface RocketMQProducer {

    String topic() default "";

    String tag() default "";

}
