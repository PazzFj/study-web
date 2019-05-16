package com.pazz.springboot.rocketmq.example.rocketmq;

import com.pazz.springboot.rocketmq.example.exception.RocketMQException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.Collection;

/**
 * @author: 彭坚
 * @create: 2019/5/16 13:49
 * @description:
 */
public abstract class AbstractRocketMQProducer implements RocketMQProducer {

    protected final Log log = LogFactory.getLog(getClass());

    private String tag;

    private MQProducer producer;

    private String topic;

    // 同步发送
    @Override
    public void send(Object msgObj) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message);
            this.doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    //同步发送
    @Override
    public void send(Object msgObj, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message, timeout);
            this.doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    // 异步发送
    @Override
    public void send(Object msgObj, SendCallback sendCallback) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, sendCallback);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, SendCallback sendCallback, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, sendCallback, timeout);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    /**
     * 不关心消息是否送达，可以提高发送tps
     */
    @Override
    public void sendOneWay(Object msgObj) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.sendOneway(message);
            log.info("sendOneway rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueue mq) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message, mq);
            doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueue mq, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message, mq, timeout);
            doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueue mq, SendCallback sendCallback) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, mq, sendCallback);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueue mq, SendCallback sendCallback, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, mq, sendCallback, timeout);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void sendOneWay(Object msgObj, MessageQueue mq) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.sendOneway(message, mq);
            log.info("sendOneway rocketmq message");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueueSelector selector, Object arg) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message, selector, arg);
            doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueueSelector selector, Object arg, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            SendResult sendResult = producer.send(message, selector, arg, timeout);
            doAfterSynSend(message, sendResult);
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueueSelector selector, Object arg, SendCallback sendCallback) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, selector, arg, sendCallback);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void send(Object msgObj, MessageQueueSelector selector, Object arg, SendCallback sendCallback, long timeout) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.send(message, selector, arg, sendCallback, timeout);
            log.info("send rocketmq message asyn");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    @Override
    public void sendOneWay(Object msgObj, MessageQueueSelector selector, Object arg) throws RocketMQException {
        if(null == msgObj){
            return;
        }
        Message message = createMessage(getTopic(), getTag(), msgObj);
        try {
            producer.sendOneway(message, selector, arg);
            log.info("sendOneway rocketmq message");
        } catch (Exception e) {
            doSendException(e, message);
        }
    }

    /**
     * 打印日志
     */
    @Override
    public void doAfterSynSend(Message message, SendResult sendResult) {
        log.info("send rocketmq message success . message : " + message.toString() + " result :" + sendResult.toString());
    }

    @Override
    public void doAfterSynSend(Collection<Message> messages, SendResult sendResult) {
        messages.forEach(message -> doAfterSynSend(message, sendResult));
    }

    @Override
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public MQProducer getProducer() {
        return producer;
    }

    public void setProducer(MQProducer producer) {
        this.producer = producer;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    private void doSendException(Exception e, Message message) {
        log.error("消息发送失败: " + message.toString());
        throw new RocketMQException("消息发送失败", e);
    }
}
