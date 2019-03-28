package com.pazz.springboot.mybatis.serivce.impl;

import com.pazz.springboot.mybatis.dao.TestMapper;
import com.pazz.springboot.mybatis.entity.TestEntity;
import com.pazz.springboot.mybatis.serivce.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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

    public List<TestEntity> queryTestList(String name) {
        return mapper.queryTestList(name);
    }

    @Transactional
    @Override
    public List<TestEntity> selectById(String... id) {
        return mapper.selectByIds(Arrays.asList(id));
    }
}
