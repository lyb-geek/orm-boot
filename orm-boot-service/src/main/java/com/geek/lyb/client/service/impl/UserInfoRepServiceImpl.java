package com.geek.lyb.client.service.impl;


import com.geek.lyb.client.service.UserInfoService;
import com.geek.lyb.demo.mongo.dao.UserInfoRepository;
import com.geek.lyb.demo.mongo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userInfoRepService")
@Transactional
public class UserInfoRepServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findUserInfoById(Long id) {
        return  userInfoRepository.findById(id).get();
    }

    @Override
    public boolean saveUserInfo(UserInfo record) {
        userInfoRepository.save(record);
        return true;
    }

    @Override
    public boolean deleteUserInfoById(Long id) {
        userInfoRepository.deleteById(id);

        if(userInfoRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<UserInfo> findAllByRealName(String realName) {
        return userInfoRepository.findAllByRealNameLike(realName);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }
}
