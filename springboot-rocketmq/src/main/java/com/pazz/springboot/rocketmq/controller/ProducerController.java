package com.pazz.springboot.rocketmq.controller;

import com.pazz.springboot.rocketmq.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/12/3 10:17
 * @description:
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private IProducerService producerService;

    @GetMapping("add")
    public void add() {
        producerService.addPerson(null);
    }

}
