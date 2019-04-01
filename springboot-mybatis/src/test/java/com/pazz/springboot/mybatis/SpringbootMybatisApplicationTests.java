package com.pazz.springboot.mybatis;

import com.pazz.springboot.mybatis.entity.TestEntity;
import com.pazz.springboot.mybatis.serivce.ITestService;
import com.pazz.springboot.mybatis.serivce.impl.TestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Test
    public void contextLoads() {
//        //spring-web 从Web应用下的一个或多个XML配置文件中加载应用上下文
//        ApplicationContext ac1 = new XmlWebApplicationContext();
        //spring-context 从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
//        ApplicationContext ac2 = new ClassPathXmlApplicationContext();
//        ITestService testService = ac2.getBean("testService", TestService.class);
//        System.out.println(testService.queryTestList(""));
//        //spring-context 从文件系统下的一个或多个XML配置中加载上下文定义
//        ApplicationContext ac3 = new FileSystemXmlApplicationContext();
//        //spring-context  从一个或多个基于Java的配置类中加载Spring应用上下文
//        ApplicationContext ac4 = new AnnotationConfigApplicationContext();
//        //spring-web 从一个或多个基于Java的配置类中加载Spring Web应用上下文
//        ApplicationContext ac5 = new AnnotationConfigWebApplicationContext();

//        int s = 11;
//        System.out.println(((Object) s).getClass());
//
//        char c = 'a';
//        System.out.println(((Object)c).getClass());
//
//        String className = TestEntity.class.getName();
//        try {
//            System.out.println(Class.forName(className));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        InputStream inputStream = SpringbootMybatisApplicationTests.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sessionFactory.openSession();
//        TestEntity tests = sqlSession.selectOne("queryTestList", new TestEntity("kobe"));
//        System.out.println(tests);

//        Field[] fields = LoginEntity.class.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
////            System.out.println(fields[i].getGenericType() + "---" + fields[i].getDeclaringClass());
//            Type type = TypeParameterResolver.resolveFieldType(fields[i], fields[i].getDeclaringClass());
//            System.out.println(type);
//        }
//
//        LoginEntity login = new LoginEntity("copyName");
//        LoginEntity login2 = new LoginEntity();
//        PropertyCopier.copyBeanProperties(LoginEntity.class, login, login2);
//        System.out.println(login2);


    }

}
