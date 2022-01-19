package com.pazz.study.rocketmq.example.configuration;

import com.pazz.study.rocketmq.example.rocketmq.AbstractRocketMQProducer;
import com.pazz.study.rocketmq.example.rocketmq.AbstractRocketMQPushConsumer;
import com.pazz.study.rocketmq.example.utils.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/5/16 11:32
 * @description:
 */
@Configuration
@ConditionalOnBean(annotation = EnableRocketMQConfiguration.class)      //使启动生效
@ConditionalOnClass(DefaultMQProducer.class)
@EnableConfigurationProperties(RocketMQProperties.class)
@AutoConfigureAfter({AbstractRocketMQProducer.class, AbstractRocketMQPushConsumer.class})
public class RocketMQAutoConfiguration implements ApplicationContextAware {

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private RocketMQProperties properties;

    private DefaultMQProducer producer;

    protected ApplicationContext applicationContext;

    @PostConstruct
    public void init() throws Exception {
        initProducer();
        initConsumer();
    }

    /**
     * 初始化生产者
     * 一个程序无论发送多种消息. 只会有一个producer 提供者
     * 程序在通过发送消息时都是使用同一个Producer  而 这个Producer 实在Configuration中创建被使用
     * 然后配置对应的topic 及tag 在通过对应的方式发送消息
     */
    private void initProducer() throws Exception {
        if (producer == null) {
            if (properties.getProducerGroup() == null) {
                throw new Exception("producer null exception");
            }
            producer = new DefaultMQProducer(properties.getProducerGroup());
            producer.setVipChannelEnabled(properties.isVipChannelEnable());
            producer.setNamesrvAddr(properties.getNameServerAddress());
            producer.start();
        }
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RocketMQProducer.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            publishProducer(entry.getKey(), entry.getValue());
        }
    }

    private void publishProducer(String beanName, Object bean) {
        // 判断该类是否 AbstractRocketMQProducer 子类
        if (!AbstractRocketMQProducer.class.isAssignableFrom(bean.getClass())) {
            throw new RuntimeException(beanName + " - producer未继承AbstractRocketMQProducer");
        }
        // 设置rocket producer 生产者, 使消息发送
        AbstractRocketMQProducer abstractMQProducer = (AbstractRocketMQProducer) bean;
        abstractMQProducer.setProducer(producer);

        RocketMQProducer mqProducer = applicationContext.findAnnotationOnBean(beanName, RocketMQProducer.class);
        String topic = mqProducer.topic();
        if (!StringUtil.isEmpty(topic)) {
            abstractMQProducer.setTopic(topic);
        }

        String tag = mqProducer.tag();
        if (!StringUtil.isEmpty(tag)) {
            abstractMQProducer.setTag(tag);
        }
        log.info(String.format("%s is ready to produce message", beanName));
    }

    private void initConsumer() throws Exception {
        if (properties.isConsumerEnable()) {
            Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RocketMQConsumer.class);
            for (Map.Entry<String, Object> entry : beans.entrySet()) {
                consumerMessage(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 创建消费组, topic, tag,
     */
    private void consumerMessage(String beanName, Object bean) throws Exception {
        RocketMQConsumer mqConsumer = applicationContext.findAnnotationOnBean(beanName, RocketMQConsumer.class);
        if (StringUtil.isEmpty(mqConsumer.consumerGroup())) {
            throw new RuntimeException("consumer's consumerGroup must be defined");
        }
        if (StringUtil.isEmpty(mqConsumer.topic())) {
            throw new RuntimeException("consumer's topic must be defined");
        }
        String consumerGroup = applicationContext.getEnvironment().getProperty(mqConsumer.consumerGroup());
        if (StringUtil.isEmpty(consumerGroup)) {
            consumerGroup = mqConsumer.consumerGroup();
        }
        String topic = applicationContext.getEnvironment().getProperty(mqConsumer.topic());
        if (StringUtil.isEmpty(topic)) {
            topic = mqConsumer.topic();
        }
        if (!AbstractRocketMQPushConsumer.class.isAssignableFrom(bean.getClass())) {
            throw new RuntimeException(bean.getClass().getName() + " - consumer未实现IMQPushConsumer接口");
        }

        AbstractRocketMQPushConsumer abstractRocketMQPushConsumer = (AbstractRocketMQPushConsumer) bean;

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(properties.getNameServerAddress());
        consumer.setVipChannelEnabled(properties.isVipChannelEnable());
        consumer.subscribe(topic, mqConsumer.tag());
        consumer.setInstanceName(abstractRocketMQPushConsumer.getInstanceName());
        consumer.setMessageModel(mqConsumer.messageMode());
        consumer.setConsumeFromWhere(abstractRocketMQPushConsumer.getConsumeFromWhere());
        consumer.setConsumeThreadMin(abstractRocketMQPushConsumer.getConsumeThreadMin());
        consumer.setConsumeThreadMax(abstractRocketMQPushConsumer.getConsumeThreadMax());
        consumer.setConsumeMessageBatchMaxSize(abstractRocketMQPushConsumer.getConsumeMessageBatchMaxSize());
        consumer.setPullBatchSize(abstractRocketMQPushConsumer.getPullBatchSize());

        consumer.setMessageListener((MessageListenerConcurrently)(msgs, context) -> abstractRocketMQPushConsumer.dealMessage(msgs, context));
        consumer.start();
        log.info(String.format("%s is ready to subscribe message", bean.getClass().getName()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
