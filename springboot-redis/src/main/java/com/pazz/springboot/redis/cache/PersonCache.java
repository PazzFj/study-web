package com.pazz.springboot.redis.cache;

import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.provider.ICacheProvider;
import com.pazz.springboot.redis.storage.RedisCacheStorage;
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
        super.setCacheProvider(new PersonProvider());
    }

    @Autowired
    public void setCacheStorage(RedisCacheStorage<String, Person> cacheStorage) {
        super.setCacheStorage(cacheStorage);
    }
}
