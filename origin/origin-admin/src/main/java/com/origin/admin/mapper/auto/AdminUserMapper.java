package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.AdminUser;
import com.origin.admin.entity.po.AdminUserExample;
import java.util.List;

public interface AdminUserMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AdminUserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String userId);

    /**
     *
     * @mbg.generated
     */
    int insert(AdminUser record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AdminUser record);

    /**
     *
     * @mbg.generated
     */
    List<AdminUser> selectByExample(AdminUserExample example);

    /**
     *
     * @mbg.generated
     */
    AdminUser selectByPrimaryKey(String userId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AdminUser record);
}