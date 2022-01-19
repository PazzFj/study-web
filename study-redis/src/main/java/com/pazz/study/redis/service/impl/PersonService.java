package com.pazz.study.redis.service.impl;

import com.pazz.study.redis.cache.ICache;
import com.pazz.study.redis.provider.PersonCache;
import com.pazz.study.redis.entity.Person;
import com.pazz.study.redis.cache.CacheManager;
import com.pazz.study.redis.service.IPersonService;
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
//        ICache<String, Person> cache = CacheManager.getInstance().getCache(PersonCache.UUID);
//        ((PersonCache) ((AbstractTestARedisCache) cache)).addPerson(person);
    }

}
