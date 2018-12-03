package com.pazz.springboot.rocketmq.service.impl;

import com.pazz.springboot.rocketmq.entity.Person;
import com.pazz.springboot.rocketmq.service.IConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 22:28
 * @description:
 */
@Service
public class ConsumerService implements IConsumerService {

    @Override
    public void addPerson(List<Person> personList) {
        System.out.println("rocketmq send data" + personList.size());
        personList.forEach(person -> {
            System.out.println(person);
        });
    }

}
