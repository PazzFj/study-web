package com.pazz.study.rocketmq.example.mq.server;

import com.pazz.study.rocketmq.example.configuration.RocketMQProducer;
import com.pazz.study.rocketmq.example.rocketmq.AbstractRocketMQProducer;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/5/16 18:30
 * @description:
 */
@Component
@RocketMQProducer(topic = "PRODUCER_TOPIC", tag = "TEST_TAG")
public class ProducerServer extends AbstractRocketMQProducer {

    public void send(){
        send("测试发送消息~");
    }

}
