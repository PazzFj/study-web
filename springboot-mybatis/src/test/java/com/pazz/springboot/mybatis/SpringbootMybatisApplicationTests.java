package com.pazz.springboot.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Test
    public void contextLoads() {
        //spring-web 从Web应用下的一个或多个XML配置文件中加载应用上下文
        ApplicationContext ac1 = new XmlWebApplicationContext();
        //spring-context 从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
        ApplicationContext ac2 = new ClassPathXmlApplicationContext();
        //spring-context 从文件系统下的一个或多个XML配置中加载上下文定义
        ApplicationContext ac3 = new FileSystemXmlApplicationContext();
        //spring-context  从一个或多个基于Java的配置类中加载Spring应用上下文
        ApplicationContext ac4 = new AnnotationConfigApplicationContext();
        //spring-web 从一个或多个基于Java的配置类中加载Spring Web应用上下文
        ApplicationContext ac5 = new AnnotationConfigWebApplicationContext();

    }

}
