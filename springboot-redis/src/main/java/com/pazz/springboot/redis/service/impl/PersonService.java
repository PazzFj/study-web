package com.pazz.springboot.redis.service.impl;

import com.pazz.springboot.redis.cache.AbstractRedisCache;
import com.pazz.springboot.redis.cache.PersonCache;
import com.pazz.springboot.redis.entity.Person;
import com.pazz.springboot.redis.manager.CacheManager;
import com.pazz.springboot.redis.service.IPersonService;
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
        AbstractRedisCache<Person> redisCache = CacheManager.getInstance().getCache(PersonCache.UUID);
        return redisCache.get(name);
    }

}
