package com.pazz.springboot.mybatis.serivce.impl;

import com.pazz.springboot.mybatis.dao.LoginMapper;
import com.pazz.springboot.mybatis.entity.Login;
import com.pazz.springboot.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Peng Jian
 * @date: 2018/6/22 13:51
 * @description:
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private LoginMapper loginDao;

    @Override
    public List<Login> queryLoginList() {
        List<Login> loginList = loginDao.queryLoginList();
        return loginList;
    }

}
