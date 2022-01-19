package com.pazz.study.mongodb.controller;

import com.pazz.study.mongodb.entity.LogInfo;
import com.pazz.study.mongodb.service.ILogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/27 14:32
 * @description:
 */
@RestController
@RequestMapping("/logInfo")
public class LogInfoController {

    @Autowired
    private ILogInfoService logInfoService;

    @PostMapping("/insert")
    public void insert(@RequestBody LogInfo logInfo) {
        logInfoService.insert(logInfo);
    }

    @GetMapping("/queryAll")
    @ResponseBody
    public List<LogInfo> queryAll(LogInfo logInfo) {
        return logInfoService.query(logInfo);
    }

}
