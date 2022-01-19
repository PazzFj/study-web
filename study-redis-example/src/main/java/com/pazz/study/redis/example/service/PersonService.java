package com.pazz.study.redis.example.service;

import com.pazz.study.redis.example.cache.CacheManage;
import com.pazz.study.redis.example.cache.ICache;
import com.pazz.study.redis.example.cache.cache.PersonRedisCache;
import com.pazz.study.redis.example.dao.PersonDao;
import com.pazz.study.redis.example.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
