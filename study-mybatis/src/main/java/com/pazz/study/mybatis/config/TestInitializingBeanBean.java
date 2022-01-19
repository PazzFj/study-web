package com.pazz.study.mybatis.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/4/16 9:19
 * @description:
 */
@Component
public class TestInitializingBeanBean implements ApplicationContextAware, BeanFactoryAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("applicationContext: " + applicationContext);
        System.out.println("applicationContext: " + applicationContext.getBean("testTransactionFactory", TestTransactionFactory.class).getProperties());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory: " + beanFactory);
        System.out.println("beanFactory: " + beanFactory.getBean("testTransactionFactory", TestTransactionFactory.class).getProperties());
    }
}
