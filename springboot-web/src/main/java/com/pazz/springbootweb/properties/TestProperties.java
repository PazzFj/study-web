package com.pazz.springbootweb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: 彭坚
 * @create: 2018/8/24 16:16
 * @description:
 */
@Component
@ConfigurationProperties(prefix = "framework")
public class TestProperties {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
