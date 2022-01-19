package com.pazz.study.redis.example.configuration;

import com.pazz.study.redis.example.cache.redis.RedisCacheStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:33
 * @description:
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(CacheProperties.class)
public class CacheAutoConfiguration {
    @Autowired
    private CacheProperties properties;

    @Bean
    @ConditionalOnClass(RedisTemplate.class)
    @ConditionalOnMissingBean
    public RedisCacheStorage redisCacheStorage(RedisTemplate redisTemplate) {
        RedisCacheStorage redisCacheStorage = new RedisCacheStorage();
        redisCacheStorage.setRedisTemplate(redisTemplate);
        redisCacheStorage.setExpire(properties.getExpireAfter());
        return redisCacheStorage;
    }



}
