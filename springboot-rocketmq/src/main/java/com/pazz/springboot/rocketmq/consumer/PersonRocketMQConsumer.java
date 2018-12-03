package com.pazz.springboot.rocketmq.consumer;

import com.pazz.springboot.rocketmq.configuration.RocketMQConsumer;
import com.pazz.springboot.rocketmq.core.AbstractRocketMQPushConsumer;
import com.pazz.springboot.rocketmq.entity.Person;
import com.pazz.springboot.rocketmq.service.IConsumerService;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/3 22:26
 * @description:
 */
@Component
@RocketMQConsumer(consumerGroup = "PERSON_SYNC_DATA", topic = "TOPIC_PERSON")
public class PersonRocketMQConsumer extends AbstractRocketMQPushConsumer<List<Person>> {

    @Autowired
    private IConsumerService consumerService;

    @Override
    public boolean process(List<Person> object, MessageExt messageExt, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        consumerService.addPerson(object);
        return true;
    }
}
