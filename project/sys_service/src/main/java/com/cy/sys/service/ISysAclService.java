package com.cy.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.common.utils.apiUtil.ApiResp;
import com.cy.sys.pojo.entity.SysAcl;
import com.cy.sys.pojo.param.acl.AclPageParam;
import com.cy.sys.pojo.param.acl.AclParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CY
 * @since 2020-11-26
 */
public interface ISysAclService extends IService<SysAcl> {

    ApiResp add(AclParam param) throws Exception;

    ApiResp edit(AclParam param) throws Exception;

    ApiResp listPage(AclPageParam param) throws Exception;
}
