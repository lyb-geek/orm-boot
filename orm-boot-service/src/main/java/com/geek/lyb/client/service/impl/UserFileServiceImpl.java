package com.geek.lyb.client.service.impl;


import com.geek.lyb.client.service.UserFileService;
import com.geek.lyb.demo.orm.jpa.dao.UserFileDao;
import com.geek.lyb.demo.orm.jpa.model.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserFileServiceImpl implements UserFileService {

    @Autowired
    private UserFileDao userFileDao;

    @Override
    public UserFile findUserFileById(Long id) {
        return userFileDao.findUserFileById(id);
    }

    @Transactional
    @Override
    public boolean saveUserFile(UserFile record) {
        return userFileDao.saveUserFile(record);
    }

    @Transactional
    @Override
    public boolean deleteUserFileById(Long id) {
        return userFileDao.deleteUserFileById(id);
    }

    @Override
    public List<UserFile> findAllByUserFileName(String fileName) {
        return userFileDao.findAllByUserFileName(fileName);
    }

    @Override
    public List<UserFile> findAll() {
        return userFileDao.findAll();
    }
}
