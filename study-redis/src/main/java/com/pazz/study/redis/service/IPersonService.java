package com.pazz.study.redis.service;

import com.pazz.study.redis.entity.Person;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:06
 * @description:
 */
public interface IPersonService {

    Person getPerson(String name);

    void addPerson(Person person);

}
