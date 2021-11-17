package com.origin.admin.controller;

import com.origin.admin.annotation.OperLog;
import com.origin.admin.constants.ResultCodeEnum;
import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.service.IAdminUsersService;
import com.origin.admin.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/15 15:21
 */
@RestController
@RequestMapping("/api/users")
@Api(tags = "系统：用户管理")
public class AdminUsersController {

    @Autowired
    private IAdminUsersService iAdminUsersService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "添加-管理员注册", notes = "用户注册")
    @OperLog(operModul = "管理员添加", operType = "添加", operDesc = "")
    public Result register(@Validated @RequestBody AdminUserBo adminUserBo){
        Boolean register = iAdminUsersService.register(adminUserBo);
        if(!register){
            return Result.error(ResultCodeEnum.REGISTER_FAIL);
        }
        return Result.success();
    }
}
