package com.pazz.springboot.redis.example.service;

import com.pazz.springboot.redis.example.entity.PersonEntity;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2019/4/11 16:11
 * @description:
 */
public interface IPersonService {

    List<PersonEntity> findPersonByParam(String name);

    PersonEntity findPersonById(int id);

}
