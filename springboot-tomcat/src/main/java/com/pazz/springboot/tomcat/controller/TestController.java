package com.pazz.springboot.tomcat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/11/26 9:32
 * @description:
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    @GetMapping(value = "/tomcat/{name}", produces = "application/json", consumes = "application/json")
    @GetMapping(value = "/tomcat/{name}", produces = "application/json;charset=utf-8")
    public String tomcat(@PathVariable("name") String name) {
        return "tomcat: == " + name;
    }

}
