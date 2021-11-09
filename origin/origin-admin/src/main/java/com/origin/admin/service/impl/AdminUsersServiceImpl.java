package com.origin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.entity.po.AdminUsers;
import com.origin.admin.mapper.AdminUsersMapper;
import com.origin.admin.service.IAdminUsersService;
import com.origin.admin.utils.SaltUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台管理员 服务实现类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
@Service
public class AdminUsersServiceImpl extends ServiceImpl<AdminUsersMapper, AdminUsers> implements IAdminUsersService {

    @Override
    public List<AdminUsers> findUserByName(String userName) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<AdminUsers>();
        wrapper.eq("user_name", userName);
        return list(wrapper);
    }

    @Override
    public Boolean register(AdminUserBo adminUserBo) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", adminUserBo.getUserName());
        final List<AdminUsers> list = list(wrapper);
        if(list.size() > 0){
            new RuntimeException("该账号已注册");
        }
        AdminUsers users = new AdminUsers();
        BeanUtils.copyProperties(adminUserBo, users);
        final String salt = SaltUtil.getSalt(8);
        users.setPassword(SaltUtil.MD5Encryption(users.getPassword(), salt))
                .setSalt(salt)
                .setCreateTime(new Date())
                .setUpdateTime(new Date())
                .setIsDeleted(0);
        return save(users);
    }
}
