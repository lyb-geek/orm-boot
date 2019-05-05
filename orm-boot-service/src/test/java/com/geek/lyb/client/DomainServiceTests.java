package com.geek.lyb.client;


import com.geek.lyb.client.service.DomainService;
import com.geek.lyb.demo.orm.mybatisplus.model.Domain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DomainServiceTests {

    @Autowired
    private DomainService domainService;


    @Test
    public void testSaveDomain(){
        Domain domain = Domain.builder().domainName("beta.cn").createTime(new Date()).updateTime(new Date()).build();

        boolean flag = domainService.save(domain);

        Assert.assertTrue(flag);
    }


    @Test
    public void testUpdateDomain(){
        Domain domain = Domain.builder().id(3L).domainName("onetest.cn").updateTime(new Date()).build();

        boolean flag = domainService.updateById(domain);

        Assert.assertTrue(flag);

    }



    @Test
    public void testDeleteById(){
        boolean flag = domainService.removeById(6L);
        Assert.assertTrue(flag);
    }


    @Test
    public void testList(){
        List<Domain> domains = domainService.list();

        Assert.assertNotNull(domains);

        domains.forEach(domain-> System.out.println(domain));
    }

    @Test
    public void testListByDoaminName(){
        List<Domain> domains = domainService.findAllByDomainName("test");

        Assert.assertNotNull(domains);

        domains.forEach(domain-> System.out.println(domain));
    }

}
