package com.pazz.study.rocketmq.example.controller;

import com.pazz.study.rocketmq.example.service.ClientService;
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
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("consumer")
    @ResponseBody
    public String consumer(){
        return service.consumer();
    }

}
