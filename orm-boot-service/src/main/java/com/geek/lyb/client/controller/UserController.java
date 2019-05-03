package com.geek.lyb.client.controller;


import com.geek.lyb.demo.orm.mybatis.model.User;
import com.geek.lyb.client.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/user")
@Api(value = "用户模块",tags = "基于mybaits版本的用户模块")
public class UserController {


    @Autowired
    private UserService userService;



    @ApiOperation(value = "查找用户",notes = "根据用户ID查找用户")
    @ApiImplicitParam(name = "id",value="用户id",required = true,dataType = "Long")
    @ApiResponse(message = "返回用户信息",response = User.class,code = 200)
    @RequestMapping(value="/findUserById/{id}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("id") Long id){
        log.info("findUserById->id:{}",id);
        return userService.findUserById(id);
    }


    @ApiOperation(value = "保存更新用户",notes = "根据用户ID来判断是进行新增或者更新用户")
    @ApiResponse(message = "返回操作标识位，true为操作成功、false为操作失败",reference = "boolean",code = 200)
    @PostMapping(value="/save")
   public boolean saveUser(@RequestBody User record){
        log.info("saveUser-> user:{}",record);
        return userService.saveUser(record);

   }

   @ApiOperation(value="删除用户",notes = "根据ID删除用户")
   @ApiImplicitParam(name="id",value="用户ID",required = true,dataType = "Long")
   @ApiResponse(message = "返回删除标识位，true为删除成功,false为删除失败",response = boolean.class,code = 200)
   @GetMapping(value="/deleteUserById")
   public boolean deleteUserById(Long id){
        log.info("deleteUserById-> id:{}",id);

        return userService.deleteUserById(id);

   }

   @ApiOperation(value="查找用户列表",notes = "根据用户名称模糊匹配用户对象")
   @ApiImplicitParam(name="userName",value = "用户名",required = true,dataType = "String")
   @ApiResponse(message = "返回符合条件的用户列表",response = User.class,code = 200)
   @GetMapping(value="/findAllByUserName")
   public List<User> findAllByUserName(String userName){
       log.info("findAllByUserName-> userName:{}",userName);

       return userService.findAllByUserName(userName);
   }

   @ApiOperation(value="查找用户列表",notes = "查找用户列表")
   @ApiResponse(message = "返回用户列表",response = User.class,code = 200)
   @GetMapping(value="/list")
   public List<User> findAll(){

        List<User> users = userService.findAll();

        users.forEach(user->log.info("{}",user));


        return users;

   }
}
