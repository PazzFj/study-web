package com.pazz.springboot.mybatis.dao;

import com.pazz.springboot.mybatis.entity.TestEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:31
 * @description:
 */
@Repository
public interface TestMapper {

    List<TestEntity> queryTestList(@Param("name") String name);

    List<TestEntity> selectByIds(@Param("list") List<String> ids);

}
