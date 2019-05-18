package com.geek.lyb.client.service;


import com.geek.lyb.demo.mongo.model.UserInfo;

import java.util.List;

public interface UserInfoService {

     UserInfo findUserInfoById(Long id);


    boolean saveUserInfo(UserInfo record);


    boolean deleteUserInfoById(Long id);


    List<UserInfo> findAllByRealName(String realName);


    List<UserInfo> findAll();

}
