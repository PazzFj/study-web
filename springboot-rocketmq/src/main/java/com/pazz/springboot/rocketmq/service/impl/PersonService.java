package com.pazz.springboot.rocketmq.service.impl;

import com.pazz.springboot.rocketmq.entity.Person;
import com.pazz.springboot.rocketmq.service.IPersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:46
 * @description:
 */
@Service
public class PersonService implements IPersonService {

    public void addPerson(List<Person> persons) {
        System.out.println(persons.size());
    }

}
