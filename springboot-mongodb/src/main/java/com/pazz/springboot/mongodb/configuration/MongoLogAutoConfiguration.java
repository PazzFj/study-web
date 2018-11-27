package com.pazz.springboot.mongodb.configuration;

import com.pazz.springboot.mongodb.core.MongoLogSender;
import com.pazz.springboot.mongodb.properties.LogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author: 彭坚
 * @create: 2018/11/26 23:07
 * @description:
 */
@Configuration
@ConditionalOnClass({MongoTemplate.class, MongoLogSender.class})
@ConditionalOnBean(MongoTemplate.class)
@AutoConfigureAfter(MongoDataAutoConfiguration.class)
@EnableConfigurationProperties(LogProperties.class)
@Import(MongoDataAutoConfiguration.class)
@ConditionalOnProperty(prefix = "spring.boot.mongodb", name = "uri")
public class MongoLogAutoConfiguration {

    @Autowired
    private LogProperties properties;

    private MongoTemplate mongoTemplate;

    public MongoLogAutoConfiguration(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Bean
    @ConditionalOnMissingBean
    public MongoLogSender mongoLogSender() {
        MongoLogSender mongoLogSender = new MongoLogSender(mongoTemplate);
        mongoLogSender.setCollectionName(properties.getMongo().getCollectionName());
        mongoLogSender.setCollectionTTLIndexExpireSeconds(properties.getMongo().getCollectionTTLIndexExpireSeconds());
        mongoLogSender.setCollectionTTLIndexName(properties.getMongo().getCollectionTTLIndexName());
        mongoLogSender.setThreadSize(properties.getMongo().getThreadSize());
        return mongoLogSender;
    }

}
