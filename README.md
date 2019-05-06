## 本项目集成的功能

- mybatis入门

    使用mybatis-generator-maven-plugin进行entity、dao、xml自动生成
    
- mybatisplus入门

    使用com.geek.lyb.demo.orm.mybatisplus.util.MybatisPlusCodeGenerator进行entity、dao、service、controller、xml自动生成

- spring data jpa入门

     通过自定义注解IgnoreNullValue来配置字段值为null值，按需更新。当jpa进行UPDATE时，如果字段值存在NULL值，IgnoreNullValue(TRUE)，则忽略字段值为NULL值的属性更新

- 使用flyway来管理数据库版本

- 自定义autoconfiguration来进行dao自动配置

- 自定义starter对业务引用jar包依赖进行管理

- 使用swagger2进行rest api 进行接口文档在线生成以及调试

  项目启动后通过访问[http://localhost:8080/doc.html](http://localhost:8080/doc.html)进行文档在线查看以及调试
  
  
  



