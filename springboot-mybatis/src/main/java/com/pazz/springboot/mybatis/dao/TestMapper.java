package com.pazz.springboot.mybatis.dao;

import com.pazz.springboot.mybatis.entity.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/12/18 17:31
 * @description:
 */
@Repository
public interface TestMapper extends Mapper<Test> {

    List<Test> queryTestList(@Param("name") String name);

}
