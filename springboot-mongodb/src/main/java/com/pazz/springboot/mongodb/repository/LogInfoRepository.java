package com.pazz.springboot.mongodb.repository;

import com.pazz.springboot.mongodb.entity.LogInfo;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/27 15:01
 * @description:
 */
public interface LogInfoRepository {

    void insert(LogInfo logInfo);

    List<LogInfo> query(LogInfo logInfo);

}
