package com.geek.lyb.client.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwaggerBootstrapUI
public class SwaggerConfig {


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .version("1.0")
                .title("rest API在线接口文档 ")
                .description("构建数据存储相关的rest API 在线接口文档")
                .contact(new Contact("orm","http://localhost:8080","orm@geek.lyb.cn"))
                .termsOfServiceUrl("http://www.geek.lyb.cn").build();
    }


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.geek.lyb.client.controller"))
                .paths(PathSelectors.any()).build();
    }


}
