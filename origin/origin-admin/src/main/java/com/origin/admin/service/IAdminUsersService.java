package com.origin.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.entity.po.AdminUsers;

import java.util.List;

/**
 * <p>
 * 后台管理员 服务类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
public interface IAdminUsersService extends IService<AdminUsers> {

    List<AdminUsers> findUserByName(String userName);

    Boolean register(AdminUserBo adminUserBo);

}
