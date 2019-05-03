package com.geek.lyb.demo.orm.jpa.dao;

import com.geek.lyb.demo.orm.jpa.model.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserFileDao {

    @Autowired
    private UserFileRepository userFileRepository;

    public UserFile findUserFileById(Long id){

        return userFileRepository.getOne(id);
    }


    public boolean saveUserFile(UserFile record){
        record = userFileRepository.save(record);

        if(record.getId() != null){
            return true;
        }

        return false;
    }


    public boolean deleteUserFileById(Long id){
       userFileRepository.deleteById(id);

      return !userFileRepository.existsById(id);
    }


    public List<UserFile> findAllByUserFileName(String fileName){

        return userFileRepository.findAllByFileNameLike("%"+fileName+"%");

    }


    public List<UserFile> findAll(){

        return userFileRepository.findAll();
    }

}
