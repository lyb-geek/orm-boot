package com.geek.lyb.client.controller;


import com.geek.lyb.client.service.DomainService;
import com.geek.lyb.demo.orm.mybatisplus.model.Domain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyb-geek
 * @since 2019-04-30
 */
@RestController
@RequestMapping("/domain")
@Api(value = "域名模块",tags = "基于mybaitsplus版本的域名模块")
@Slf4j
public class DomainController {


    @Autowired
    private DomainService domainService;



    @ApiOperation(value = "查找域名",notes = "根据域名ID查找域名")
    @ApiImplicitParam(name = "id",value="域名id",required = true,dataType = "Long")
    @ApiResponse(message = "返回域名信息",response = Domain.class,code = 200)
    @RequestMapping(value="/findById/{id}",method = RequestMethod.GET)
    public Domain findDoaminById(@PathVariable("id") Long id){
        log.info("findDoaminById->id:{}",id);
        return domainService.getById(id);
    }


    @ApiOperation(value = "保存更新域名",notes = "根据域名ID来判断是进行新增或者更新域名")
    @ApiResponse(message = "返回操作标识位，true为操作成功、false为操作失败",reference = "boolean",code = 200)
    @PostMapping(value="/save")
    public boolean saveDomain(@RequestBody Domain record){
        log.info("saveDomain-> domain:{}",record);
        return domainService.saveOrUpdate(record);

    }

    @ApiOperation(value="删除域名",notes = "根据ID删除域名")
    @ApiImplicitParam(name="id",value="域名ID",required = true,dataType = "Long")
    @ApiResponse(message = "返回删除标识位，true为删除成功,false为删除失败",response = boolean.class,code = 200)
    @GetMapping(value="/deleteById")
    public boolean deleteDomainById(Long id){
        log.info("deleteDomainById-> id:{}",id);

        return domainService.removeById(id);

    }

    @ApiOperation(value="查找域名列表",notes = "根据域名名称模糊匹配用户对象")
    @ApiImplicitParam(name="domainName",value = "域名",required = true,dataType = "String")
    @ApiResponse(message = "返回符合条件的用户列表",response = Domain.class,code = 200)
    @GetMapping(value="/findAllByDomainName")
    public List<Domain> findAllByDomainName(String domainName){
        log.info("findAllByDomainName-> domainName:{}",domainName);

        return domainService.findAllByDomainName(domainName);
    }

    @ApiOperation(value="查找域名列表",notes = "查找域名列表")
    @ApiResponse(message = "返回域名列表",response = Domain.class,code = 200)
    @GetMapping(value="/list")
    public List<Domain> findAll(){

        List<Domain> domains = domainService.list();

        domains.forEach(domain->log.info("{}",domain));


        return domains;

    }

}
