package com.pazz.springboot.mybatis.serivce;

import com.pazz.springboot.mybatis.entity.LoginEntity;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 13:50
 * @description:
 */
public interface ILoginService {

    List<LoginEntity> queryLoginList(LoginEntity loginEntity);

    void addLogin(LoginEntity loginEntity);

}
