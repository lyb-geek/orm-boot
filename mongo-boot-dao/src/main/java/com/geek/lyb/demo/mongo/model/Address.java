package com.geek.lyb.demo.mongo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

   @ApiModelProperty(name="addressName",value="地址名称",required = true,example = "东大街100号")
   private String addressName;

   @ApiModelProperty(name="floor",value="楼层",required = true,example = "10")
   private Integer floor;
}
