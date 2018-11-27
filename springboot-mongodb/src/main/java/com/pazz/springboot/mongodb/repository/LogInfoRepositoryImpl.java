package com.pazz.springboot.mongodb.repository;

import com.pazz.springboot.mongodb.core.MongoLogSender;
import com.pazz.springboot.mongodb.entity.LogInfo;
import com.pazz.springboot.mongodb.entity.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: 彭坚
 * @create: 2018/11/27 15:02
 * @description:
 */
@Component
public class LogInfoRepositoryImpl implements LogInfoRepository {

    @Autowired
    private MongoLogSender logSender;

    @Override
    public void insert(LogInfo logInfo) {
        List<Object> logs = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            LogInfo log = new LogInfo();
            log.setDate(new Date());
            log.setAppName(logInfo.getAppName());
            log.setRequestId(UUID.randomUUID().toString());
            log.setModuleName("Module");
            log.setUserName(logInfo.getUserName());
            log.setUrl("http://www.baidu.com");
            log.setType(LogType.WEB);
            log.setClazz(LogInfo.class.getName());
            log.setMethod("save()");
            log.setIp("127.0.0.1");
            log.setHostName("localhost");
            log.setHostAddress("127.0.0.1");
            log.setVersion("1.0.0");
            log.setMacAddress("0.0.0.0/0");
            log.setMessage("message...");
            log.setAction(LogInfo.BEGIN_ACTION);
            log.setResult("result...");
            logs.add(log);
        }
        logSender.send(logs);
    }

    @Override
    public List<LogInfo> query(LogInfo logInfo) {
        Query query = new Query();
        if(logInfo != null && logInfo.getUserName() != null && logInfo.getUserName() != ""){
            query.addCriteria(Criteria.where("userName").is(logInfo.getUserName()));
        }
        return logSender.getMongoTemplate().find(query, LogInfo.class);
    }
}
