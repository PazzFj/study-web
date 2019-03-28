package com.pazz.springboot.mybatis.serivce;

import com.pazz.springboot.mybatis.entity.TestEntity;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:35
 * @description:
 */
public interface ITestService {

    List<TestEntity> queryTestList(String name);

    List<TestEntity> selectById(String... id);

}
