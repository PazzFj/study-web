package com.pazz.study.redis.provider;

import com.pazz.study.redis.cache.ICacheProvider;
import com.pazz.study.redis.entity.Person;
import com.pazz.study.redis.redis.storage.AbstractRedisCache;
import com.pazz.study.redis.redis.storage.RedisCacheStorage;
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
