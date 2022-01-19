package com.pazz.study.rocketmq.example.mq.cilent;

import com.pazz.study.rocketmq.example.configuration.RocketMQConsumer;
import com.pazz.study.rocketmq.example.rocketmq.AbstractRocketMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/5/16 18:39
 * @description:
 */
@Component
@RocketMQConsumer(consumerGroup = "example", topic = "PRODUCER_TOPIC")
public class ConsumerClient extends AbstractRocketMQPushConsumer<String> {

    @Override
    protected boolean process(String object, MessageExt messageExt, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.println("save: " + object);
        return true;
    }
}
