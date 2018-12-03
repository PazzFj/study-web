package com.pazz.springboot.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SpringbootRocketmqApplicationTests {

    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
            producer.setNamesrvAddr("47.98.219.97:9876");
            producer.setVipChannelEnabled(false);
            producer.start();
            for (int i = 1000; i < 2000; i++) {
                try {
                    Message msg = new Message("TopicTest", "TagA", ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                    SendResult sendResult = producer.send(msg);
                    System.out.printf("%s%n", sendResult);
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.sleep(1000);
                }
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
