package com.pazz.springboot.rocketmq.configuration;

import com.pazz.springboot.rocketmq.core.AbstractRocketMQProducer;
import com.pazz.springboot.rocketmq.core.AbstractRocketMQPushConsumer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2018/12/3 16:27
 * @description:
 */
@Configuration
@ConditionalOnBean(annotation = EnableRocketMQConfiguration.class)
@ConditionalOnClass(DefaultMQProducer.class)
@EnableConfigurationProperties(RocketMQProperties.class)
@AutoConfigureAfter({AbstractRocketMQProducer.class, AbstractRocketMQPushConsumer.class})
public class RocketMQConfiguration implements ApplicationContextAware {

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private RocketMQProperties properties;

    protected ApplicationContext applicationContext;

    private DefaultMQProducer producer;

    @PostConstruct
    public void init() throws Exception {
        //初始化生产者
        initProducer();
        //初始化消费者
        initConsumer();
    }

    private void initProducer() throws Exception {
        if (null == producer) {
            if (StringUtils.isEmpty(properties.getProducerGroup())) {
                throw new RuntimeException("请在配置文件中指定消息发送方group！");
            }
            producer = new DefaultMQProducer(properties.getProducerGroup());
            producer.setNamesrvAddr(properties.getNameServerAddress());
            producer.setVipChannelEnabled(properties.isVipChannelEnabled());
            producer.start();
        }
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RocketMQProducer.class);
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            publishProducer(entry.getKey(), entry.getValue());
        }
    }


    private void initConsumer() throws Exception {
        if (properties.isConsumerEnable()) {
            Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RocketMQConsumer.class);
            for (Map.Entry<String, Object> entry : beans.entrySet()) {
                publishConsumer(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 发布Producer
     */
    private void publishProducer(String beanName, Object bean) throws Exception {
        if (!AbstractRocketMQProducer.class.isAssignableFrom(bean.getClass())) {
            throw new RuntimeException(beanName + " - producer未继承AbstractRocketMQProducer");
        }
        AbstractRocketMQProducer abstractMQProducer = (AbstractRocketMQProducer) bean;
        abstractMQProducer.setProducer(producer);
        RocketMQProducer mqProducer = applicationContext.findAnnotationOnBean(beanName, RocketMQProducer.class);
        String topic = mqProducer.topic();
        if (!StringUtils.isEmpty(topic)) {
            String transTopic = applicationContext.getEnvironment().getProperty(topic);
            if (StringUtils.isEmpty(transTopic)) {
                abstractMQProducer.setTopic(topic);
            } else {
                abstractMQProducer.setTopic(transTopic);
            }
        }
        String tag = mqProducer.tag();
        if (!StringUtils.isEmpty(tag)) {
            String transTag = applicationContext.getEnvironment().getProperty(tag);
            if (StringUtils.isEmpty(transTag)) {
                abstractMQProducer.setTag(tag);
            } else {
                abstractMQProducer.setTag(transTag);
            }
        }
        log.info(String.format("%s is ready to produce message", beanName));
    }

    /**
     * 发布Consumer
     */
    private void publishConsumer(String beanName, Object bean) {
        RocketMQConsumer mqConsumer = applicationContext.findAnnotationOnBean(beanName, RocketMQConsumer.class);
        if (StringUtils.isEmpty(mqConsumer.consumerGroup())) {
            throw new RuntimeException("consumer's consumerGroup must be defined");
        }
        if (StringUtils.isEmpty(mqConsumer.topic())) {
            throw new RuntimeException("consumer's topic must be defined");
        }
        String consumerGroup = applicationContext.getEnvironment().getProperty(mqConsumer.consumerGroup());
        if (StringUtils.isEmpty(consumerGroup)) {
            consumerGroup = mqConsumer.consumerGroup();
        }
        String topic = applicationContext.getEnvironment().getProperty(mqConsumer.topic());
        if (StringUtils.isEmpty(topic)) {
            topic = mqConsumer.topic();
        }
        if(!AbstractRocketMQPushConsumer.class.isAssignableFrom(bean.getClass())){
            throw new RuntimeException(bean.getClass().getName() + " - consumer未实现IMQPushConsumer接口");
        }

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
