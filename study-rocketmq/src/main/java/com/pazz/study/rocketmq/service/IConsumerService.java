package com.pazz.study.rocketmq.service;

import com.pazz.study.rocketmq.entity.Person;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 22:27
 * @description:
 */
public interface IConsumerService {

    void addPerson(List<Person> personList);

}
