package com.origin.admin.mapper;

import com.origin.admin.entity.po.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/14 23:26
 */
public interface IAdminUserMapper {

    AdminUser findUserName(String account);
}
