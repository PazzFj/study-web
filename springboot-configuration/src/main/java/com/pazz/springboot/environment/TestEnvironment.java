package com.pazz.springboot.environment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * @author: 彭坚
 * @create: 2018/8/27 16:28
 * @description: 測試Environment
 */
public class TestEnvironment implements EnvironmentPostProcessor {

    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("ConfigurableEnvironment ======>>> ");
        MutablePropertySources sources = environment.getPropertySources();
        Iterator<PropertySource<?>> iterator = sources.iterator();
        while (iterator.hasNext()) {
            System.out.println("PropertySource: " + iterator.next());
        }
    }

}
