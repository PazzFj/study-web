package com.pazz.springbootweb.configuration;

import com.pazz.springbootweb.properties.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 彭坚
 * @create: 2018/8/24 16:17
 * @description:
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestConfiguration {

    @Autowired
    private TestProperties testProperties;

    public TestConfiguration(){
        System.out.println("initial" + testProperties.getName());
    }

}
