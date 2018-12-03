package com.pazz.springboot.rocketmq.core;

import com.pazz.springboot.rocketmq.exception.RocketMQException;
import com.pazz.springboot.rocketmq.util.JsonUtils;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.Collection;

/**
 * @author: 彭坚
 * @create: 2018/12/3 11:21
 * @description:
 */
public interface RocketMQProducer {

    /**
     * 获取topic
     */
    String getTopic();

    /**
     * 获取Tag
     */
    String getTag();

    /**
     * 获取Producer
     */
    MQProducer getProducer();

    /**
     * 同步发送消息
     */
    void send(Object msgObj) throws RocketMQException;

    /**
     * 同步发送消息
     */
    void send(Object msgObj, long timeout) throws RocketMQException;
    /**
     * 异步发送消息
     */
    void send(Object msgObj, SendCallback sendCallback) throws RocketMQException;

    /**
     * 异步发送消息
     */
    void send(Object msgObj, SendCallback sendCallback, long timeout) throws RocketMQException;

    /**
     * 不关心消息是否送达，可以提高发送tps
     */
    void sendOneway(Object msgObj) throws RocketMQException;

    /**
     * 异步只发送一次消息到指定队列
     */
    void sendOneway(Object msgObj, MessageQueue mq) throws RocketMQException;

    /**
     * 同步发送消息到指定队列
     */
    void send(Object msgObj, MessageQueue mq) throws RocketMQException;

    /**
     * 同步发送消息到指定队列
     */
    void send(Object msgObj, MessageQueue mq, long timeout) throws RocketMQException;

    /**
     * 异步发送消息到指定队列
     */
    void send(Object msgObj, MessageQueue mq, SendCallback sendCallback) throws RocketMQException;

    /**
     * 异步发送消息到指定队列
     */
    void send(Object msgObj, MessageQueue mq, SendCallback sendCallback, long timeout) throws RocketMQException;

    /**
     * 同步发送消息到指定队列 （MessageQueueSelector）
     */
    void send(Object msgObj, MessageQueueSelector selector, Object arg) throws RocketMQException;

    /**
     * 同步发送消息到指定队列 （MessageQueueSelector）
     */
    void send(Object msgObj, MessageQueueSelector selector, Object arg, long timeout) throws RocketMQException;

    /**
     * 异步发送消息到指定队列 （MessageQueueSelector）
     */
    void send(Object msgObj, MessageQueueSelector selector, Object arg, SendCallback sendCallback) throws RocketMQException;

    /**
     * 异步发送消息到指定队列 （MessageQueueSelector）
     */
    void send(Object msgObj, MessageQueueSelector selector, Object arg, SendCallback sendCallback, long timeout) throws RocketMQException;

    /**
     * 异步只发送一次消息到指定队列  （MessageQueueSelector）
     */
    void sendOneway(Object msgObj, MessageQueueSelector selector, Object arg) throws RocketMQException;

    /**
     * 默认创建消息
     */
    default Message createMessage(String topic, String tag, Object msgObj) {
        String json = JsonUtils.toJson(msgObj);
        if (StringUtils.isEmpty(topic)) {
            if (StringUtils.isEmpty(getTopic())) {
                throw new RuntimeException("no topic defined to send this message");
            }
            topic = getTopic();
        }
        Message message = new Message(topic, json.getBytes(Charset.forName("utf-8")));
        setMessageKeys(message, msgObj);
        if (!StringUtils.isEmpty(tag)) {
            message.setTags(tag);
        } else if (!StringUtils.isEmpty(getTag())) {
            message.setTags(getTag());
        }
        return message;
    }

    /**
     * 设置Message Keys
     */
    default void setMessageKeys(Message message, Object msgObj) {

    }

    /**
     * 同步发送后处理方法
     */
    default void doAfterSynSend(Message message, SendResult sendResult) {

    }

    /**
     * 批量同步发送后处理方法
     */
    default void doAfterSynSend(Collection<Message> messages, SendResult sendResult) {

    }

}
