package com.pazz.springboot.example.provider;

import com.pazz.springboot.example.cache.provider.ITTLCacheProvider;
import com.pazz.springboot.example.redis.storage.RedisCacheStorage;
import com.pazz.springboot.example.redis.storage.AbstractTTLRedisCache;
import com.pazz.springboot.example.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/11/30 10:49
 * @description:
 */
@Component
public class PersonCache extends AbstractTTLRedisCache<Person> {

    public static final String UUID = Person.class.getName();

    public String getUUID() {
        return UUID;
    }

    @Autowired
    public void setCacheProvider(ITTLCacheProvider<Person> cacheProvider) {
        super.setCacheProvider(cacheProvider);
    }

    @Autowired
    public void setCacheStorage(RedisCacheStorage<String, Person> cacheStorage) {
        super.setCacheStorage(cacheStorage);
    }
}
