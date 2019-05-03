package com.geek.lyb.demo.orm.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Api(value = "用户实体对象")
public class User {
    @ApiModelProperty(name="id",value="id",example = "1")
    private Long id;

    @ApiModelProperty(name="userName",value="用户名",required = true,example = "李雷")
    private String userName;

    @ApiModelProperty(name="sex",value="性别",required = true,example = "男")
    private String sex;

    @ApiModelProperty(name="domain",value="域名",required = true,example = "www.35.cn")
    private String domain;

    @ApiModelProperty(name="deptName",value="部门名称",required = true,example = "oa产品部")
    private String deptName;

    @ApiModelProperty(name="email",value="邮件",required = true,example = "lilei@35.cn")
    private String email;

    @ApiModelProperty(name="mobile",value="手机",required = true,example = "1880000009")
    private String mobile;

    @ApiModelProperty(name="createTime",value="创建时间",example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @ApiModelProperty(name="updateTime",value="更新时间",required = true,example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}