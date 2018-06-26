package com.pazz.springboot.mybatis.controller;

import com.pazz.springboot.mybatis.entity.Login;
import com.pazz.springboot.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 13:53
 * @description:
 */
@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/query")
    @ResponseBody
    public List<Login> queryLoginList(){
        return loginService.queryLoginList();
    }

}
