package com.geek.lyb.client.controller;


import com.geek.lyb.client.service.UserInfoService;
import com.geek.lyb.demo.mongo.model.UserInfo;
import com.geek.lyb.demo.orm.jpa.model.UserFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/userInfo")
@Api(value = "用户信息模块",tags = "基于mongo版本的用户信息模块")
public class UserInfoController {



    @Autowired
    @Qualifier("userInfoRepService")
    private UserInfoService userInfoService;



    @ApiOperation(value = "查找用户信息",notes = "根据用户信息ID查找用户信息")
    @ApiImplicitParam(name = "id",value="用户信息id",required = true,dataType = "Long")
    @ApiResponse(message = "返回用户信息信息",response = UserInfo.class,code = 200)
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public UserInfo findUserInfoById(@PathVariable("id") Long id){
        log.info("findUserInfoById->id:{}",id);
        return userInfoService.findUserInfoById(id);
    }


    @ApiOperation(value = "保存更新用户信息",notes = "根据用户信息ID来判断是进行新增或者更新用户信息")
    @ApiResponse(message = "返回操作标识位，true为操作成功、false为操作失败",reference = "boolean",code = 200)
    @PostMapping(value="/save")
    public boolean saveUserInfo(@RequestBody UserInfo record){
        log.info("saveUserInfo-> userInfo:{}",record);
        return userInfoService.saveUserInfo(record);

    }

    @ApiOperation(value="删除用户信息",notes = "根据ID删除用户信息")
    @ApiImplicitParam(name="id",value="用户信息ID",required = true,dataType = "Long")
    @ApiResponse(message = "返回删除标识位，true为删除成功,false为删除失败",response = boolean.class,code = 200)
    @GetMapping(value="/deleteById")
    public boolean deleteUserInfoById(Long id){
        log.info("deleteById-> id:{}",id);

        return userInfoService.deleteUserInfoById(id);

    }

    @ApiOperation(value="查找用户信息列表",notes = "根据用户名称模糊匹配用户文件对象")
    @ApiImplicitParam(name="realName",value = "用户名",required = true,dataType = "String")
    @ApiResponse(message = "返回符合条件的用户文件列表",response = UserFile.class,code = 200)
    @GetMapping(value="/findAllByRealName")
    public List<UserInfo> findAllByRealName(String realName){
        log.info("findAllByRealName-> realName:{}",realName);

        return userInfoService.findAllByRealName(realName);
    }

    @ApiOperation(value="查找用户信息列表",notes = "查找用户信息列表")
    @ApiResponse(message = "返回用户信息列表",response = UserInfo.class,code = 200)
    @GetMapping(value="/list")
    public List<UserInfo> findAll(){

        List<UserInfo> userInfos = userInfoService.findAll();

        userInfos.forEach(userInfo->log.info("{}",userInfo));


        return userInfos;

    }
}
