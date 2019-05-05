package com.geek.lyb.demo.orm.mybatisplus.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
* <p>
    * 
    * </p>
*
* @author lyb-geek
* @since 2019-05-05
*/
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @TableName("t_domain")
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Api(value = "域名实体对象")
    public class Domain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name="id",value="id",example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(name="domainName",value="域名",required = true,example = "hello.cn")
    private String domainName;

    @ApiModelProperty(name="createTime",value="创建时间",example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty(name="updateTime",value="更新时间",required = true,example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;




}
