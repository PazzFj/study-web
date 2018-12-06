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
public class PersonCache extends AbstractRedisCache<String> {

    public static final String UUID = PersonCache.class.getName();

    public String getUUID() {
        return UUID;
    }

    public void addPerson(Person person) {
        String json = JsonUtils.toJson(person);
        cacheStorage.set(getKey(person.getPName()), json);
    }

    @Autowired
    public void setCacheProvider(ICacheProvider<String> provider) {
        super.setCacheProvider(provider);
    }

    @Autowired
    public void setCacheStorage(RedisCacheStorage<String, String> cacheStorage) {
        super.setCacheStorage(cacheStorage);
    }
}
