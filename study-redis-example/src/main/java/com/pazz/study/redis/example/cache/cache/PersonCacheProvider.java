package com.pazz.study.redis.example.cache.cache;

import com.pazz.study.redis.example.cache.mysql.ICacheProvider;
import com.pazz.study.redis.example.dao.PersonDao;
import com.pazz.study.redis.example.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:45
 * @description:
 */
@Component
public class PersonCacheProvider implements ICacheProvider<PersonEntity> {

    @Autowired
    private PersonDao personDao;

    public PersonEntity get(String key) {
        return personDao.findPersonById(Integer.valueOf(key));
    }

}
