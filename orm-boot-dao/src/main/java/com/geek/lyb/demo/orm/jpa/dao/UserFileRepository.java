package com.geek.lyb.demo.orm.jpa.dao;

import com.geek.lyb.demo.orm.jpa.model.UserFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFileRepository extends JpaRepository<UserFile,Long> {

    List<UserFile> findAllByFileNameLike(String fileName);
}
