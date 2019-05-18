package com.geek.lyb.client.service.impl;


import com.geek.lyb.client.service.UserInfoService;
import com.geek.lyb.demo.mongo.common.template.CustomMongoTemplate;
import com.geek.lyb.demo.mongo.model.UserInfo;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private CustomMongoTemplate mongoTemplate;

    @Override
    public UserInfo findUserInfoById(Long id) {

        return mongoTemplate.findById(id, UserInfo.class) ;
    }

    @Override
    public boolean saveUserInfo(UserInfo record) {
        mongoTemplate.save(record);
        return true;
    }

    @Override
    public boolean deleteUserInfoById(Long id) {
        UserInfo userInfo = UserInfo.builder().id(id).build();
        DeleteResult result = mongoTemplate.remove(userInfo);

        if(result.getDeletedCount() > 0) return true;
        return false;
    }

    @Override
    public List<UserInfo> findAllByRealName(String realName) {

        Query query = new Query();

        Criteria criteria = Criteria.where("realName").regex(realName);

        query.addCriteria(criteria);
        return mongoTemplate.find(query,UserInfo.class);
    }

    @Override
    public List<UserInfo> findAll() {
        return mongoTemplate.findAll(UserInfo.class);
    }
}
