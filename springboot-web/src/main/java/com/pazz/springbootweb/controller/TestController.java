package com.pazz.springbootweb.controller;

import com.pazz.springbootweb.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/8/24 16:35
 * @description:
 */
@RestController
public class TestController {

//    @Autowired
//    private TestProperties testProperties;
    @Autowired
    private TestBean testBean;

    @ResponseBody
    @GetMapping("/test")
    public String test(){
//        return testProperties.getName();
        return testBean.getName();
    }

}
