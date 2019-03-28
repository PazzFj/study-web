package com.pazz.springboot.mybatis;

import com.pazz.springboot.mybatis.entity.Login;
import org.apache.ibatis.reflection.TypeParameterResolver;
import org.apache.ibatis.reflection.property.PropertyCopier;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Test
    public void contextLoads() {
//        //spring-web 从Web应用下的一个或多个XML配置文件中加载应用上下文
//        ApplicationContext ac1 = new XmlWebApplicationContext();
//        //spring-context 从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
//        ApplicationContext ac2 = new ClassPathXmlApplicationContext();
//        //spring-context 从文件系统下的一个或多个XML配置中加载上下文定义
//        ApplicationContext ac3 = new FileSystemXmlApplicationContext();
//        //spring-context  从一个或多个基于Java的配置类中加载Spring应用上下文
//        ApplicationContext ac4 = new AnnotationConfigApplicationContext();
//        //spring-web 从一个或多个基于Java的配置类中加载Spring Web应用上下文
//        ApplicationContext ac5 = new AnnotationConfigWebApplicationContext();

//        InputStream inputStream = SpringbootMybatisApplicationTests.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sessionFactory.openSession();
//        List<com.pazz.springboot.mybatis.entity.Test> tests = sqlSession.selectList("queryTestList");
//        System.out.println(tests.size());

        Field[] fields = Login.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i].getGenericType() + "---" + fields[i].getDeclaringClass());
            Type type = TypeParameterResolver.resolveFieldType(fields[i], fields[i].getDeclaringClass());
            System.out.println(type);
        }

        Login login = new Login("copyName");
        Login login2 = new Login();
        PropertyCopier.copyBeanProperties(Login.class, login, login2);
        System.out.println(login2);


    }

}
