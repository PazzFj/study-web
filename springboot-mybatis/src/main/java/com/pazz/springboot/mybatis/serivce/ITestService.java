package com.pazz.springboot.mybatis.serivce;

import com.pazz.springboot.mybatis.entity.Test;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:35
 * @description:
 */
public interface ITestService {

    List<Test> queryTestList(String name);

    List<Test> selectById(String... id);

}
