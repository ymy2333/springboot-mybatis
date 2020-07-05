package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.domain.User;
import com.atguigu.service.UserSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserSerivce {

//    @Autowired
    @Resource
    UserDao userDao;


    @Override
    public List<User> finaAll() {
        return userDao.findAll();
    }
}
