package com.pazz.springboot.redis.example.service;

import com.pazz.springboot.redis.example.dao.PersonDao;
import com.pazz.springboot.redis.example.entity.PersonEntity;
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
        return personDao.findPersonById(id);
    }

}
