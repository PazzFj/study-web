package com.pazz.study.mybatis.serivce.impl;

import com.pazz.study.mybatis.dao.LoginMapper;
import com.pazz.study.mybatis.entity.LoginEntity;
import com.pazz.study.mybatis.serivce.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    public List<LoginEntity> queryLoginList(LoginEntity loginEntity) {
        List<LoginEntity> loginEntityList = loginDao.queryLoginList(loginEntity.getUserName());
        return loginEntityList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addLogin(LoginEntity loginEntity) {
        System.out.println(loginEntity);
        loginDao.insert(loginEntity);
    }
}
