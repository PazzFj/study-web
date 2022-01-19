package com.pazz.study.rocketmq;

import com.pazz.study.rocketmq.configuration.EnableRocketMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRocketMQConfiguration
public class SpringbootRocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRocketmqApplication.class, args);
    }
}
