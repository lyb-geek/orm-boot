package com.geek.lyb.demo.orm.mybatis.dao;


import com.geek.lyb.demo.orm.mybatis.model.User;
import com.geek.lyb.demo.orm.mybatis.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;


    public User findUserById(Long id){

        return userMapper.selectByPrimaryKey(id);
    }


    public boolean saveUser(User record){
        int count = 0;
        if(record.getId() != null){
            count =  userMapper.updateByPrimaryKeySelective(record);
        }else{
            count = userMapper.insertSelective(record);
        }

        if(count > 0){
            return true;
        }

        return false;
    }


    public boolean deleteUserById(Long id){
        int count = userMapper.deleteByPrimaryKey(id);

        if(count > 0) return true;

        return false;
    }


    public List<User> findAllByUserName(String userName){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameLike("%"+userName+"%");

        return userMapper.selectByExample(userExample);

    }


    public List<User> findAll(){
        UserExample userExample =  new UserExample();

        return userMapper.selectByExample(userExample);
    }


}
