package com.origin.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.admin.constants.ConstantUtil;
import com.origin.admin.entity.bo.AdminUserBo;
import com.origin.admin.entity.po.AdminUsers;
import com.origin.admin.entity.po.UsersRole;
import com.origin.admin.filter.BusinessException;
import com.origin.admin.mapper.AdminUsersMapper;
import com.origin.admin.service.IAdminUsersService;
import com.origin.admin.service.IUsersRoleService;
import com.origin.admin.utils.SaltUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
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

    @Autowired private IUsersRoleService iUsersRoleService;

    @Override
    public List<AdminUsers> findUserByName(String userName) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<AdminUsers>();
        wrapper.eq("user_name", userName);
        return list(wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(AdminUserBo adminUserBo) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", adminUserBo.getUserName())
                .or().eq("phone", adminUserBo.getPhone())
                .or().eq("email", adminUserBo.getEmail())
                .ne("id", adminUserBo.getId());
        final List<AdminUsers> list = list(wrapper);
        if(list.size() > 0){
            throw new BusinessException(ConstantUtil.DUPLICATE_INPUT_INFORMATION);
        }
        AdminUsers users;
        if(adminUserBo.getId() == null){
            users = new AdminUsers();
            BeanUtils.copyProperties(adminUserBo, users);
            final String salt = SaltUtil.getSalt(8);
            users.setPassword(SaltUtil.MD5Encryption(users.getPassword(), salt))
                    .setSalt(salt)
                    .setCreateTime(new Date());
        }else {
            users = getById(adminUserBo.getId());
            if(users==null){
                throw new BusinessException("未查询到该用户");
            }
            BeanUtils.copyProperties(adminUserBo, users);
            users.setPassword(SaltUtil.MD5Encryption(adminUserBo.getPassword(), users.getSalt()));
            users.setUpdateTime(new Date());
        }
        //添加用户与角色之间的关系
        if(saveOrUpdate(users)){
            QueryWrapper<UsersRole> urWrapper = new QueryWrapper<>();
            urWrapper.eq("user_id", users.getId());
            iUsersRoleService.remove(urWrapper);
            LinkedList<UsersRole> role = new LinkedList<>();
            adminUserBo.getRoleId().forEach(ids -> {
                UsersRole ur = new UsersRole();
                ur.setUserId(users.getId());
                ur.setRoleId(ids);
                role.add(ur);
            });
            return iUsersRoleService.saveBatch(role);
        }
        throw new BusinessException("录入失败");
    }

    @Override
    public List<AdminUsers> findUserByPhone(String phone) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", phone);
        return list(wrapper);
    }

    @Override
    public List<AdminUsers> findUserByEmail(String email) {
        QueryWrapper<AdminUsers> wrapper = new QueryWrapper<>();
        wrapper.eq("email", email);
        return list(wrapper);
    }
}
