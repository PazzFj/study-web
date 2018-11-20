package com.pazz.springboot.mybatis.controller;

import com.pazz.springboot.mybatis.entity.Login;
import com.pazz.springboot.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 13:53
 * @description:
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @ResponseBody
    @GetMapping("/query")
    public List<Login> queryLoginList(Login login) {
        return loginService.queryLoginList(login);
    }

}
