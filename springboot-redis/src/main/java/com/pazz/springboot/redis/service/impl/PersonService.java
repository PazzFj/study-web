package com.pazz.springboot.redis.service.impl;

import com.pazz.springboot.redis.cache.AbstractRedisCache;
import com.pazz.springboot.redis.cache.PersonCache;
import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.manager.CacheManager;
import com.pazz.springboot.redis.service.IPersonService;
import com.pazz.springboot.redis.util.JsonUtils;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:08
 * @description:
 */
@Service
public class PersonService implements IPersonService {

    //com.pazz.springboot.redis.cache.PersonCache

    public Person getPerson(String name) {
        AbstractRedisCache<String> redisCache = CacheManager.getInstance().getCache(PersonCache.UUID);
        return JsonUtils.toObject(redisCache.get(name), Person.class);
    }

    public void addPerson(Person person) {
        AbstractRedisCache<String> redisCache = CacheManager.getInstance().getCache(PersonCache.UUID);
        ((PersonCache)redisCache).addPerson(person);
    }

}
