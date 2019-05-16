package com.pazz.springboot.rocketmq.example.service;

import com.pazz.springboot.rocketmq.example.mq.server.ProducerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2019/5/16 18:27
 * @description:
 */
@Service
public class ProducerService {

    @Autowired
    private ProducerServer producerServer;

    public void send(){
        producerServer.send();
    }

}
