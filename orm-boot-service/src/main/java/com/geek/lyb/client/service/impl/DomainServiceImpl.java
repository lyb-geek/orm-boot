package com.geek.lyb.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.lyb.client.service.DomainService;
import com.geek.lyb.demo.orm.mybatisplus.dao.DomainMapper;
import com.geek.lyb.demo.orm.mybatisplus.model.Domain;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyb-geek
 * @since 2019-05-05
 */
@Service
public class DomainServiceImpl extends ServiceImpl<DomainMapper, Domain> implements DomainService {
    @Override
    public List<Domain> findAllByDomainName(String domainName) {
        List<Domain> domains = baseMapper.selectList(new QueryWrapper<Domain>().like(StringUtils.isNotEmpty(domainName),"domain_name",domainName));
        return domains;
    }

}
