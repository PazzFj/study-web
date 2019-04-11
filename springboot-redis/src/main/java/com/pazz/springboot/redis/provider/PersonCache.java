package com.pazz.springboot.redis.provider;

import com.pazz.springboot.redis.cache.ICacheProvider;
import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.redis.storage.AbstractRedisCache;
import com.pazz.springboot.redis.redis.storage.RedisCacheStorage;
import com.pazz.springboot.redis.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/11/28 11:12
 * @description:
 */
@Component
public class PersonCache extends AbstractRedisCache<Person> {

    public static final String UUID = PersonCache.class.getName();

    public String getUUID() {
        return UUID;
    }

    @Autowired
    public void setCacheProvider(ICacheProvider<Person> provider) {
        super.setCacheProvider(provider);
    }

    @Autowired
    public void setCacheStorage(RedisCacheStorage<String, Person> cacheStorage) {
        super.setCacheStorage(cacheStorage);
    }
}
