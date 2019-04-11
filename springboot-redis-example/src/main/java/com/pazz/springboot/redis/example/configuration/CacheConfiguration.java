package com.pazz.springboot.redis.example.configuration;

import com.pazz.springboot.redis.example.cache.redis.RedisCacheStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:33
 * @description:
 */
@Configuration
public class CacheConfiguration {

    @Autowired
    private CacheProperties properties;

    @Bean
    @ConditionalOnMissingBean    //当前上下文中不存在RedisCacheStorage 对象时，才会实例化一个RedisCacheStorage
    @ConditionalOnBean({RedisTemplate.class})  //仅仅在当前上下文中存在RedisTemplate 对象时，才会实例化一个RedisCacheStorage
    public RedisCacheStorage redisCacheStorage(RedisTemplate redisTemplate){
        RedisCacheStorage storage = new RedisCacheStorage();
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);
        storage.setRedisTemplate(redisTemplate);
        storage.setExpire(properties.getExpireAfter());
        return storage;
    }

}
