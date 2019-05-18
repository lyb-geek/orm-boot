package com.geek.lyb.client;

import com.geek.lyb.demo.mongo.dao.CustomSimpleMongoRepository;
import com.geek.lyb.demo.orm.jpa.dao.CustomSimpleJpaRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = {"com.geek.lyb.demo.orm.mybatis.dao","com.geek.lyb.demo.orm.mybatisplus.dao"})
@EnableJpaRepositories(basePackages = "com.geek.lyb.demo.orm.jpa.dao", repositoryBaseClass = CustomSimpleJpaRepository.class)
@EnableMongoRepositories(basePackages = "com.geek.lyb.demo.mongo.dao",repositoryBaseClass = CustomSimpleMongoRepository.class)
@EntityScan(basePackages = "com.geek.lyb.demo.orm.jpa.model")
@EnableTransactionManagement
@EnableSwagger2
public class OrmBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrmBootDemoApplication.class, args);
	}

}
