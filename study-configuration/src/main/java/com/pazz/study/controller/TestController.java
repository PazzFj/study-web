package com.pazz.study.controller;

import com.pazz.study.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/8/24 16:35
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestBean testBean;

    @ResponseBody
    @GetMapping("/getName")
    public String getName() {
        return testBean.getName();
    }

}
