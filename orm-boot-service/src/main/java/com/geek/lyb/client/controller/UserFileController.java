package com.geek.lyb.client.controller;


import com.geek.lyb.demo.orm.jpa.model.UserFile;
import com.geek.lyb.client.service.UserFileService;
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
@RequestMapping(value="/file")
@Api(value = "用户文件模块",tags = "基于jpa版本的用户文件模块")
public class UserFileController {



    @Autowired
    private UserFileService userFileService;



    @ApiOperation(value = "查找用户文件",notes = "根据用户文件ID查找用户文件")
    @ApiImplicitParam(name = "id",value="用户文件id",required = true,dataType = "Long")
    @ApiResponse(message = "返回用户文件信息",response = UserFile.class,code = 200)
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public UserFile findUserFileById(@PathVariable("id") Long id){
        log.info("findUserFileById->id:{}",id);
        return userFileService.findUserFileById(id);
    }


    @ApiOperation(value = "保存更新用户文件",notes = "根据用户文件ID来判断是进行新增或者更新用户文件")
    @ApiResponse(message = "返回操作标识位，true为操作成功、false为操作失败",reference = "boolean",code = 200)
    @PostMapping(value="/save")
    public boolean saveUserFile(@RequestBody UserFile record){
        log.info("saveUserFile-> userFile:{}",record);
        return userFileService.saveUserFile(record);

    }

    @ApiOperation(value="删除用户文件",notes = "根据ID删除用户文件")
    @ApiImplicitParam(name="id",value="用户文件ID",required = true,dataType = "Long")
    @ApiResponse(message = "返回删除标识位，true为删除成功,false为删除失败",response = boolean.class,code = 200)
    @GetMapping(value="/deleteById")
    public boolean deleteUserFileById(Long id){
        log.info("deleteById-> id:{}",id);

        return userFileService.deleteUserFileById(id);

    }

    @ApiOperation(value="查找用户文件列表",notes = "根据文件名称模糊匹配用户文件对象")
    @ApiImplicitParam(name="fileName",value = "文件名",required = true,dataType = "String")
    @ApiResponse(message = "返回符合条件的用户文件列表",response = UserFile.class,code = 200)
    @GetMapping(value="/findAllByFileName")
    public List<UserFile> findAllByUserFileName(String fileName){
        log.info("findAllByUserFileName-> fileName:{}",fileName);

        return userFileService.findAllByUserFileName(fileName);
    }

    @ApiOperation(value="查找用户文件列表",notes = "查找用户文件列表")
    @ApiResponse(message = "返回用户文件列表",response = UserFile.class,code = 200)
    @GetMapping(value="/list")
    public List<UserFile> findAll(){

        List<UserFile> userFiles = userFileService.findAll();

        userFiles.forEach(userFile->log.info("{}",userFile));


        return userFiles;

    }
}
