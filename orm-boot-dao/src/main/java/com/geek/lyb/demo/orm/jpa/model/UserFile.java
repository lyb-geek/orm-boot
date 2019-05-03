package com.geek.lyb.demo.orm.jpa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.geek.lyb.demo.orm.jpa.annotation.IgnoreNullValue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="t_file")
@IgnoreNullValue(true)
@Api(value = "用户文件实体对象")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class UserFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name="id",value="id",example = "1")
    private Long id;

    @Column(name = "file_name")
    @ApiModelProperty(name="fileName",value="文件名",required = true,example = "李雷的附件")
    private String fileName;

    @Column(name="file_type")
    @ApiModelProperty(name="fileType",value="文件类型",required = true,example = "doc")
    private String fileType;

    @Column(name="file_path")
    @ApiModelProperty(name="filePath",value="文件路径",required = true,example = "http://www.geek.lyb.cn/lilei")
    private String filePath;

    @Column(name="file_size")
    @ApiModelProperty(name="fileSize",value="文件大小",required = true,example = "350")
    private Long fileSize;

    @ApiModelProperty(name="belong",value="文件归属",required = true,example = "李雷")
    private String belong;

    @Column(name="create_time")
    @ApiModelProperty(name="createTime",value="创建时间",example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    @Column(name="update_time")
    @ApiModelProperty(name="updateTime",value="更新时间",required = true,example = "2019-04-29 14:20:10")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;
}
