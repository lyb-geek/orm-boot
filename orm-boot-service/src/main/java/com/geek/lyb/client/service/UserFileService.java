package com.geek.lyb.client.service;


import com.geek.lyb.demo.orm.jpa.model.UserFile;

import java.util.List;

public interface UserFileService {

    UserFile findUserFileById(Long id);


    boolean saveUserFile(UserFile record);


    boolean deleteUserFileById(Long id);


    List<UserFile> findAllByUserFileName(String fileName);


    List<UserFile> findAll();
}
