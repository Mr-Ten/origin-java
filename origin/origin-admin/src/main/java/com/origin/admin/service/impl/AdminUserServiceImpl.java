package com.origin.admin.service.impl;

import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.entity.po.AdminUser;
import com.origin.admin.mapper.IAdminUserMapper;
import com.origin.admin.mapper.auto.AdminUserMapper;
import com.origin.admin.service.IAdminUserService;
import com.origin.admin.utils.SaltUtil;
import com.origin.admin.utils.SnowflakeIdWorkerUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/14 23:21
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired private IAdminUserMapper iAdminUserMapper;
    @Autowired private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser findUserName(String account) {
        return iAdminUserMapper.findUserName(account);
    }

    @Override
    public Integer register(AdminUserBo adminUserBo) {
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserBo, adminUser);
        String salt = SaltUtil.getSalt(8);
        String saltPassword = SaltUtil.MD5Encryption(adminUser.getPassword(), salt);
        adminUser.setSalt(salt)
                .setPassword(saltPassword)
                .setUserId(String.valueOf(SnowflakeIdWorkerUtil.getId()))
                .setCreateTime(new Date());
        return adminUserMapper.insert(adminUser);
    }
}
