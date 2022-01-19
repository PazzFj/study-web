package com.pazz.study.rocketmq.example;

import com.pazz.study.rocketmq.example.configuration.EnableRocketMQConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRocketMQConfiguration
public class SpringbootRocketmqExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRocketmqExampleApplication.class, args);
	}

}
