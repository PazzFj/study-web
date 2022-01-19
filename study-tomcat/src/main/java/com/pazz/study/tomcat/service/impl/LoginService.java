package com.pazz.study.tomcat.service.impl;

import com.pazz.study.tomcat.service.IService;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2019/6/27 16:56
 * @description:
 */
@Service
public class LoginService implements IService {
    public void invoke() {
        System.out.println("login");
    }
}
