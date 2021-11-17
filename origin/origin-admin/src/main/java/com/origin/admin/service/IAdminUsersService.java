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

    /**
     * 根据账号查询用户
     * @param userName
     * @return
     */
    List<AdminUsers> findUserByName(String userName);

    /**
     * 管理员注册
     * @param adminUserBo
     * @return
     */
    Boolean register(AdminUserBo adminUserBo);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    List<AdminUsers> findUserByPhone(String phone);

    /**
     * 根据Email查询用户
     * @param email
     * @return
     */
    List<AdminUsers> findUserByEmail(String email);
}
