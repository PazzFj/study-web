package com.pazz.study.mongodb.service;

import com.pazz.study.mongodb.entity.LogInfo;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/27 14:38
 * @description:
 */
public interface ILogInfoService {

    void insert(LogInfo logInfo);

    List<LogInfo> query(LogInfo logInfo);

}
