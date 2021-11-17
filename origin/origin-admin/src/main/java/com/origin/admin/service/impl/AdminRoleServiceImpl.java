package com.origin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.admin.entity.bo.RoleBo;
import com.origin.admin.entity.po.AdminRole;
import com.origin.admin.mapper.AdminRoleMapper;
import com.origin.admin.service.IAdminRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-09
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

    @Override
    public Boolean addOrUpdateRole(RoleBo roleBo) {
        AdminRole role = new AdminRole();
        BeanUtils.copyProperties(roleBo, role);
        if (roleBo.getId() != null){
            role.setUpdateTime(new Date());
        }else {
            role.setCreateTime(new Date());
        }
        return saveOrUpdate(role);
    }

    @Override
    public Boolean remove(Long id) {
        return removeById(id);
    }
}
