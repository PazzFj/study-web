package com.pazz.springboot.mybatis.controller;

import com.pazz.springboot.mybatis.serivce.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:30
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("getByName")
    @ResponseBody
    public String getByName(String name) {
        return testService.queryTestList(name).toString();
    }

}
