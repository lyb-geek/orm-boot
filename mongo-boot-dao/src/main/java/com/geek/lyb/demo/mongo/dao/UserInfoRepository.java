package com.geek.lyb.demo.mongo.dao;

import com.geek.lyb.demo.mongo.model.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserInfoRepository extends MongoRepository<UserInfo,Long> {

    List<UserInfo> findAllByRealNameLike(String realName);
}
