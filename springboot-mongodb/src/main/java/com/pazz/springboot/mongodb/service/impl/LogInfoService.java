package com.pazz.springboot.mongodb.service.impl;

import com.pazz.springboot.mongodb.entity.LogInfo;
import com.pazz.springboot.mongodb.repository.LogInfoRepository;
import com.pazz.springboot.mongodb.service.ILogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/11/27 14:39
 * @description:
 */
@Service
public class LogInfoService implements ILogInfoService {

    @Autowired
    private LogInfoRepository repository;

    @Override
    public void insert(LogInfo logInfo) {
        repository.insert(logInfo);
    }

    @Override
    public List<LogInfo> query(LogInfo logInfo) {
        return repository.query(logInfo);
    }
}
