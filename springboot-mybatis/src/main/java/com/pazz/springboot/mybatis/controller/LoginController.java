package com.pazz.springboot.mybatis.controller;

import com.pazz.springboot.mybatis.entity.LoginEntity;
import com.pazz.springboot.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<LoginEntity> queryLoginList(LoginEntity loginEntity) {
        return loginService.queryLoginList(loginEntity);
    }

    @ResponseBody
    @PostMapping("/add")
    public void addLogin(@RequestBody LoginEntity loginEntity) {
        loginService.addLogin(loginEntity);
    }

}
