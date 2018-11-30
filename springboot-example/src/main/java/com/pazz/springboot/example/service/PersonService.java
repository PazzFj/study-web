package com.pazz.springboot.example.service;

import com.pazz.springboot.example.cache.CacheManager;
import com.pazz.springboot.example.cache.ICache;
import com.pazz.springboot.example.provider.PersonCache;
import com.pazz.springboot.example.entity.Person;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:08
 * @description:
 */
@Service
public class PersonService implements IPersonService {

    public Person getPerson(String name) {
        ICache<String, Person> redisCache = CacheManager.getInstance().getCache(PersonCache.UUID);
        return redisCache.get(name);
    }

    public void addPerson(Person person) {

    }

}
