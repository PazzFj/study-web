package com.pazz.springboot.example.service;

import com.pazz.springboot.example.entity.Person;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:06
 * @description:
 */
public interface IPersonService {

    Person getPerson(String name);

    void addPerson(Person person);

}
