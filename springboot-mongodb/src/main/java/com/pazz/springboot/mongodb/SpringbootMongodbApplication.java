package com.pazz.springboot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SpringbootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMongodbApplication.class, args);
    }
}
