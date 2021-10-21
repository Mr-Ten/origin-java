package com.origin.admin.service;

import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.entity.po.AdminUser;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/14 22:21
 */
public interface IAdminUserService {
    /**
     *
     * @param account
     * @return
     */
    AdminUser findUserName(String account);

    /**
     * 注册用户
     * @param adminUserBo
     * @return
     */
    Integer register(AdminUserBo adminUserBo);
}
