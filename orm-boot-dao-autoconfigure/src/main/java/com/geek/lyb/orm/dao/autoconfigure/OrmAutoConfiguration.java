package com.geek.lyb.orm.dao.autoconfigure;

import com.geek.lyb.demo.orm.jpa.dao.UserFileDao;
import com.geek.lyb.demo.orm.mybatis.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OrmAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean(value = UserDao.class)
    public UserDao userDao(){
        log.info("userDao create...");
        return new UserDao();
    }

    @Bean
    @ConditionalOnMissingBean(value = UserFileDao.class)
    public UserFileDao userFileDao(){
        log.info("userFileDao create...");
        return new UserFileDao();
    }
}
