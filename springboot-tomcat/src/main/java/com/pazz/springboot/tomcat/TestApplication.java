package com.pazz.springboot.tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 彭坚
 * @create: 2019/5/29 0:35
 * @description:
 */
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }

}
