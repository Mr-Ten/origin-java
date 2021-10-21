package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.AdminRole;
import com.origin.admin.entity.po.AdminRoleExample;

import java.util.List;

public interface AdminRoleMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AdminRoleExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int insert(AdminRole record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AdminRole record);

    /**
     *
     * @mbg.generated
     */
    List<AdminRole> selectByExample(AdminRoleExample example);

    /**
     *
     * @mbg.generated
     */
    AdminRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AdminRole record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AdminRole record);
}
