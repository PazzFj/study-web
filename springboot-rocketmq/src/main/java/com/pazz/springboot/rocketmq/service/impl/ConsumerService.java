package com.pazz.springboot.rocketmq.service.impl;

import com.pazz.springboot.rocketmq.entity.Person;
import com.pazz.springboot.rocketmq.service.IConsumerService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        System.out.println("正在接收数据: " + personList.size() + " 时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));
        personList.forEach(person -> {
            System.out.println(person);
        });
    }

}
