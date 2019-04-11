package com.pazz.springboot.redis.example.cache.cache;

import com.pazz.springboot.redis.example.cache.AbstractRedisCache;
import com.pazz.springboot.redis.example.cache.redis.RedisCacheStorage;
import com.pazz.springboot.redis.example.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/4/11 21:38
 * @description:
 */
@Component
public class PersonRedisCache extends AbstractRedisCache<PersonEntity> {

    public static final String UUID = PersonRedisCache.class.getName();

    public String getUUID() {
        return UUID;
    }

    @Autowired
    public void setCacheProvider(PersonCacheProvider cacheProvider) {
        super.setCacheProvider(cacheProvider);
    }

    @Autowired
    public void setRedisCacheStorage(RedisCacheStorage redisCacheStorage) {
        super.setRedisCacheStorage(redisCacheStorage);
    }
}
