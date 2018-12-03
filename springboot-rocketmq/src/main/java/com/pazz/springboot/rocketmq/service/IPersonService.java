package com.pazz.springboot.rocketmq.service;

import com.pazz.springboot.rocketmq.entity.Person;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:46
 * @description:
 */
public interface IPersonService {

    void addPerson(List<Person> persons);

}
