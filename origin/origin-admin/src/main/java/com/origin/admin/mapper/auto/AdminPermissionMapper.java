package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.AdminPermission;
import com.origin.admin.entity.po.AdminPermissionExample;

import java.util.List;

public interface AdminPermissionMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AdminPermissionExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(AdminPermission record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AdminPermission record);

    /**
     *
     * @mbg.generated
     */
    List<AdminPermission> selectByExample(AdminPermissionExample example);

    /**
     *
     * @mbg.generated
     */
    AdminPermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AdminPermission record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AdminPermission record);
}
