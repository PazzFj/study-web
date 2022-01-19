package com.pazz.study.rocketmq.service;

import com.pazz.study.rocketmq.entity.Person;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:46
 * @description:
 */
public interface IProducerService {

    void addPerson(List<Person> persons);

}
