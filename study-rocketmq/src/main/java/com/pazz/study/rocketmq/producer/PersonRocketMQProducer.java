package com.pazz.study.rocketmq.producer;

import com.pazz.study.rocketmq.configuration.RocketMQProducer;
import com.pazz.study.rocketmq.core.AbstractRocketMQProducer;
import com.pazz.study.rocketmq.entity.Person;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 21:30
 * @description:
 */
@Component
@RocketMQProducer(topic = "TOPIC_PERSON", tag = "TAG_PERSON")
public class PersonRocketMQProducer extends AbstractRocketMQProducer {

    private static final String PERSON_SYNC_DATA = "PERSON_SYNC_DATA";

    @Override
    public void setMessageKeys(Message message, Object msgObj) {
        String key = PERSON_SYNC_DATA + "#" + System.currentTimeMillis();
        message.setKeys(key);
    }

    public void doBatchSend(Person person) {
        List<Person> userEntityList = new ArrayList<>();
        userEntityList.add(person);
        super.send(userEntityList);
    }

    public void doBatchSend(List<Person> personList) {
        super.send(personList);
    }

}
