package com.geek.lyb.client.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geek.lyb.demo.orm.mybatisplus.model.Domain;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyb-geek
 * @since 2019-05-05
 */
public interface DomainService extends IService<Domain> {
    List<Domain> findAllByDomainName(String domainName);

}
