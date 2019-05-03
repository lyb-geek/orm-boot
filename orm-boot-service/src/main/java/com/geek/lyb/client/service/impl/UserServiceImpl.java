package com.geek.lyb.client.service.impl;


import com.geek.lyb.demo.orm.mybatis.dao.UserDao;
import com.geek.lyb.demo.orm.mybatis.model.User;
import com.geek.lyb.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Transactional
    @Override
    public boolean saveUser(User record) {
        return userDao.saveUser(record);
    }

    @Transactional
    @Override
    public boolean deleteUserById(Long id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public List<User> findAllByUserName(String userName) {
        return userDao.findAllByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
