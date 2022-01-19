package com.pazz.study.rocketmq.example.service;

import com.pazz.study.rocketmq.example.mq.cilent.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 彭坚
 * @create: 2019/5/16 18:46
 * @description:
 */
@Service
public class ClientService {

    @Autowired
    private ConsumerClient client;

    public String consumer(){
        return "consumer success";
    }

}
