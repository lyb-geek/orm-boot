package com.geek.lyb.mongo.dao.autoconfigure;

import com.geek.lyb.demo.mongo.common.template.CustomMongoTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;

@Configuration
@Slf4j
public class MongoAutoConfiguration {


  @Bean
  @ConditionalOnMissingBean(CustomMongoTemplate.class)
  public CustomMongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter){
    return new CustomMongoTemplate(mongoDbFactory,mongoConverter);
  }
}
