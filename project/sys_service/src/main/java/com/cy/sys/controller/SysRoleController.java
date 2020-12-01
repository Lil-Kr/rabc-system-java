package com.cy.sys.controller;


import com.cy.common.utils.apiUtil.ApiResp;
import com.cy.sys.pojo.dto.aclmodule.AclModuleDto;
import com.cy.sys.pojo.param.role.RoleDeleteParam;
import com.cy.sys.pojo.param.role.RoleListPageParam;
import com.cy.sys.pojo.param.role.RoleSaveParam;
import com.cy.sys.service.ISysRoleService;
import com.cy.sys.service.impl.SysTreeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 *  角色模块
 * @author CY
 * @since 2020-11-28
 */
@RestController
@RequestMapping("/sys/role")
@Slf4j
public class SysRoleController {

    @Resource
    private ISysRoleService sysRoleService1;

    @Resource
    private SysTreeService sysTreeService1;

    /**
     * 分页查询角色列表
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("listPage")
    public ApiResp listPage (@RequestBody @Valid RoleListPageParam param) throws Exception {
        return sysRoleService1.listPage(param);
    }

    /**
     * 保存角色信息
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("add")
    public ApiResp add (@RequestBody @Valid RoleSaveParam param) throws Exception {
        return sysRoleService1.add(param);
    }

    /**
     * 修改角色信息
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("edit")
    public ApiResp edit (@RequestBody @Valid RoleSaveParam param) throws Exception {
        return sysRoleService1.edit(param);
    }

    /**
     * 删除角色信息
     * @param param
     */
    @PostMapping("delete")
    public ApiResp delete (@RequestBody @Valid RoleDeleteParam param) throws Exception {
        return sysRoleService1.delete(param);
    }

    /**
     * 获取[角色-权限]树
     * @param roleId
     * @return
     * @throws Exception
     */
    @PostMapping("roleTree")
    public ApiResp roleTree(@RequestParam("roleId") @NotNull(message = "角色id不能为空") @Valid Long roleId) throws Exception {
        List<AclModuleDto> aclModuleDtoList = sysTreeService1.roleTree(roleId);
        if (CollectionUtils.isNotEmpty(aclModuleDtoList)) {
            return ApiResp.success(aclModuleDtoList);
        }else {
            return ApiResp.failure("该角色下没有权限点明细");
        }
    }

    /**
     * 获取所有角色信息
     * @param param
     * @return
     * @throws Exception
     */
    @PostMapping("listAll")
    public ApiResp listAll (@RequestBody @Valid RoleListPageParam param) throws Exception {
        return sysRoleService1.listAll(param);
    }

}
