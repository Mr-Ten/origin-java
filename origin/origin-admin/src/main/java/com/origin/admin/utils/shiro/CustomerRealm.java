package com.origin.admin.utils.shiro;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.origin.admin.entity.po.AdminUsers;
import com.origin.admin.service.IAdminUsersService;
import com.origin.admin.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/7/26 19:33
 */
public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取用户身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        //根据主身份信息获取角色和权限信息
        //IAdminUserService userService = (IAdminUserService) ApplicationContextUtils.getBean("userService");
        //AdminUser user = userService.findRolesByUserName(primaryPrincipal);
        //授权角色信息
//        if(!CollectionUtils.isEmpty(user.getReles())){
//            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            user.getReles().forEach(role -> {
//                simpleAuthorizationInfo.addRole(role.getName());
//                //权限信息
//                List<Pers> persList = userService.findPersByRoleId(String.valueOf(role.getId()));
//                if(!CollectionUtils.isEmpty(persList)){
//                    persList.forEach(pers -> {
//                        simpleAuthorizationInfo.addStringPermission(pers.getName());
//                    });
//                }
//            });
//            return simpleAuthorizationInfo;
//        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        IAdminUsersService beanByName = ApplicationContextUtils.getBeanByName(IAdminUsersService.class);
        AdminUsers users = beanByName.findUserByName(principal).get(0);
        if(!ObjectUtils.isEmpty(users)){
            return new SimpleAuthenticationInfo(users.getUserName(), users.getPassword(), new MySimpleByteSource(users.getSalt()), this.getName());
        }
        return null;
    }
}
