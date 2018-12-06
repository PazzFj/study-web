package com.pazz.springboot.redis.service.impl;

import com.pazz.springboot.redis.cache.ICache;
import com.pazz.springboot.redis.redis.storage.AbstractRedisCache;
import com.pazz.springboot.redis.provider.PersonCache;
import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.cache.CacheManager;
import com.pazz.springboot.redis.service.IPersonService;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:08
 * @description:
 */
@Service
public class PersonService implements IPersonService {

    public Person getPerson(String name) {
        ICache<String, Person> cache = CacheManager.getInstance().getCache(PersonCache.UUID);
        return cache.get(name);
//        return JsonUtils.toObject(redisCache.get(name), Person.class);
    }

    public void addPerson(Person person) {
        ICache<String, Person> cache = CacheManager.getInstance().getCache(PersonCache.UUID);
        ((PersonCache) ((AbstractRedisCache) cache)).addPerson(person);
    }

}
