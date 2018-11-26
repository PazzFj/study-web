package com.pazz.springboot.log.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 彭坚
 * @create: 2018/11/26 12:26
 * @description:
 */
@RestController
@RequestMapping("/log")
public class JpaController {

    @GetMapping("/connect")
    public String connect() {
        return "connect";
    }

}
