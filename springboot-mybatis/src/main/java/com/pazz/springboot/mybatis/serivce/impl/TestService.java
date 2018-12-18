package com.pazz.springboot.mybatis.serivce.impl;

import com.pazz.springboot.mybatis.dao.TestMapper;
import com.pazz.springboot.mybatis.entity.Test;
import com.pazz.springboot.mybatis.serivce.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:35
 * @description:
 */
@Service
public class TestService implements ITestService {

    @Autowired
    private TestMapper mapper;

    public List<Test> queryTestList(String name) {
        if(null != name && !"".equals(name)){
            name = "%" + name + "%";
        }
        return mapper.queryTestList(name);
    }
}
