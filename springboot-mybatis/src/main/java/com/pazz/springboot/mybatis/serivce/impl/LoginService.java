package com.pazz.springboot.mybatis.serivce.impl;

import com.pazz.springboot.mybatis.dao.LoginMapper;
import com.pazz.springboot.mybatis.entity.Login;
import com.pazz.springboot.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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

    public List<Login> queryLoginList(Login login) {
        System.out.println(login);
        List<Login> loginList = loginDao.queryLoginList(login.getUserName());
        return loginList;
    }

    @Transactional
    public void addLogin(Login login) {
        System.out.println(login);
        loginDao.insert(login);
    }
}
