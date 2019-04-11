package com.pazz.springboot.redis.example.service;

import com.pazz.springboot.redis.example.cache.CacheManage;
import com.pazz.springboot.redis.example.cache.ICache;
import com.pazz.springboot.redis.example.cache.cache.PersonRedisCache;
import com.pazz.springboot.redis.example.dao.PersonDao;
import com.pazz.springboot.redis.example.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/4/11 16:12
 * @description:
 */
@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonDao personDao;

    public List<PersonEntity> findPersonByParam(String name) {
        return personDao.findPersonByParam(name);
    }

    public PersonEntity findPersonById(int id) {
        ICache<String, PersonEntity> cache = CacheManage.getInstance().getCache(PersonRedisCache.UUID);
        PersonEntity entity = cache.get(String.valueOf(id));
        return entity;
    }

}
