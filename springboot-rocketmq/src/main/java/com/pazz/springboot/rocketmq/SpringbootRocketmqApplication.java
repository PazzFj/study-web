package com.pazz.springboot.rocketmq;

import com.pazz.springboot.rocketmq.configuration.EnableRocketMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRocketMQConfiguration
public class SpringbootRocketmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRocketmqApplication.class, args);
    }
}
