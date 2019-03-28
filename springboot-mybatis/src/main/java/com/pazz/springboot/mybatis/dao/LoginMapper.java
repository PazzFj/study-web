package com.pazz.springboot.mybatis.dao;

import com.pazz.springboot.mybatis.entity.LoginEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 11:36
 * @description: LoginMapper
 */
@Repository
public interface LoginMapper extends Mapper<LoginEntity> {

    List<LoginEntity> queryLoginList(@Param("userName") String userName);

}
