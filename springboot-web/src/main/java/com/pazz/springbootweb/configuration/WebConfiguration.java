package com.pazz.springbootweb.configuration;

import com.pazz.springbootweb.properties.TestProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @author: 彭坚
 * @create: 2018/8/27 11:30
 * @description:
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
@DependsOn("testConfiguration")
public class WebConfiguration {

    public WebConfiguration() {
        System.out.println("WebConfiguration#init");
    }

}
