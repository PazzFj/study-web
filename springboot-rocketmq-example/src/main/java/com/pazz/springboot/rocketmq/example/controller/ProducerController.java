package com.pazz.springboot.rocketmq.example.controller;

import com.pazz.springboot.rocketmq.example.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2019/5/16 18:25
 * @description:
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService service;

    @GetMapping("send")
    @ResponseBody
    public String send(){
        service.send();
        return "ok";
    }

}
