package com.geek.lyb.demo.mongo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.geek.lyb.demo.mongo.annotation.IgnoreNullValue;
import com.geek.lyb.demo.mongo.common.annotation.AutoIncKey;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "userInfo")
@CompoundIndexes(@CompoundIndex(name = "idx_realName",def = "{realName:1}"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IgnoreNullValue
@Api(value = "用户信息实体对象")
public class UserInfo {

    @Id
    @AutoIncKey
    @ApiModelProperty(name="id",value="id",example = "1")
    private Long id;

    @ApiModelProperty(name="idCard",value="身份证",required = true,example = "1212121211212112")
    private String idCard;

    @ApiModelProperty(name="realName",value="姓名",required = true,example = "李雷")
    private String realName;

    @ApiModelProperty(name="sex",value="性别",required = true,example = "男")
    private String sex;

    @ApiModelProperty(name="mobile",value="电话",required = true,example = "18000000007")
    private String mobile;

    @ApiModelProperty(name="address",value="地址",required = true)
    private Address address;

    @ApiModelProperty(name="createTime",value="创建时间",example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty(name="updateTime",value="更新时间",required = true,example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;




}
