package com.geek.lyb.client.service;


import com.geek.lyb.demo.orm.mybatis.model.User;

import java.util.List;

public interface UserService {

    User findUserById(Long id);

    boolean saveUser(User record);

    boolean deleteUserById(Long id);

    List<User> findAllByUserName(String userName);

    List<User> findAll();

}
