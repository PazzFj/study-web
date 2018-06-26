package com.pazz.springboot.mybatis.dao;

import com.pazz.springboot.mybatis.entity.Login;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 11:36
 * @description: LoginDao
 */
@Repository
public interface LoginMapper {

//    @Select("select * from t_login limit 0, 1")
    List<Login> queryLoginList();

}
