package com.origin.admin.controller;

import cn.hutool.core.lang.Assert;
import com.origin.admin.entity.bo.RoleBo;
import com.origin.admin.service.IAdminRoleService;
import com.origin.admin.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/9 23:51
 */
@RestController
@RequestMapping("/api/role")
@Api(tags = "系统：角色管理")
public class AdminRoleController {

    @Autowired private IAdminRoleService iAdminRoleService;

    @PostMapping("/addOrUpdateRole")
    @ApiOperation(value = "添加/修改：角色", notes = "添加/修改一个角色")
    public Result addOrUpdateRole(@Validated @RequestBody RoleBo roleBo){
        Boolean aBoolean = iAdminRoleService.addOrUpdateRole(roleBo);
        return Result.success();
    }

    @PostMapping("/deleted")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public Result remove(Long id){
        Assert.notBlank(String.valueOf(id), "ID不能为空");
        iAdminRoleService.remove(id);
        return Result.success();
    }
}
