package com.pazz.springboot.tomcat.service.impl;

import com.pazz.springboot.tomcat.service.IService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2019/6/27 16:56
 * @description:
 */
@Primary
@Service
public class TestService implements IService {
    public void invoke() {
        System.out.println("test");
    }
}
