package com.origin.admin.service;

import com.origin.admin.entity.bo.RoleBo;
import com.origin.admin.entity.po.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-09
 */
public interface IAdminRoleService extends IService<AdminRole> {

    Boolean addOrUpdateRole(RoleBo roleBo);

    Boolean remove(Long id);
}
