package com.pazz.springboot.rocketmq.service.impl;

import com.pazz.springboot.rocketmq.entity.Person;
import com.pazz.springboot.rocketmq.producer.PersonRocketMQProducer;
import com.pazz.springboot.rocketmq.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:46
 * @description:
 */
@Service
public class ProducerService implements IProducerService {

    @Autowired
    private PersonRocketMQProducer personRocketMQProducer;

    public void addPerson(List<Person> persons) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Person person = new Person(i, "admin", "男", 3 * i + 1);
            personList.add(person);
        }
        System.out.println("正在发送数据: " + personList.size() + " 时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()));
        personRocketMQProducer.doBatchSend(personList);
    }

}
