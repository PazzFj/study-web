package com.pazz.springboot.mybatis.config;

import com.pazz.springboot.mybatis.serivce.ITestService;
import com.pazz.springboot.mybatis.serivce.impl.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2019/4/1 11:08
 * @description:
 */
@Component
public class TestAfterInitializingBean implements InitializingBean, DisposableBean, BeanFactoryAware, BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    public TestAfterInitializingBean(){
        System.out.println("constructor");
    }

    static {
        System.out.println("static initialize");
    }

    public static void test(){
        System.out.println("static method test");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties set");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("clear");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("bean factory");
    }
}
