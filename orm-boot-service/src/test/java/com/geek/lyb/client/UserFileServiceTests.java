package com.geek.lyb.client;


import com.geek.lyb.client.service.UserFileService;
import com.geek.lyb.demo.orm.jpa.model.UserFile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserFileServiceTests {

    @Autowired
    private UserFileService userFileService;

    @Test
    public void testSaveUserFile(){

        UserFile userFile = UserFile.builder().fileName("陈文茵1的附件").filePath("http://www.geek.lyb.cn/file/chenwenyin")
                                              .fileSize(300L).fileType("pdf").belong("陈文茵")
                                              .createTime(new Date()).updateTime(new Date()).build();

        boolean flag = userFileService.saveUserFile(userFile);

        Assert.assertTrue(flag);

    }


    @Test
    public void testUpdateUserFile(){


        UserFile userFile = UserFile.builder().id(5L).filePath("http://www.geek.lyb.cn/file/chenwenyin").build();

        boolean flag = userFileService.saveUserFile(userFile);

        Assert.assertTrue(flag);

    }


    @Test
    public void testDeleteById(){
        boolean flag = userFileService.deleteUserFileById(7L);
        Assert.assertTrue(flag);
    }


    @Test
    public void testList(){
        List<UserFile> userFiles = userFileService.findAll();

        Assert.assertNotNull(userFiles);

        userFiles.forEach(userFile-> System.out.println(userFile));
    }

    @Test
    public void testListByFileName(){
        List<UserFile> userFiles = userFileService.findAllByUserFileName("王");

        Assert.assertNotNull(userFiles);

        userFiles.forEach(userFile-> System.out.println(userFile));
    }


}
