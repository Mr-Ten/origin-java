package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.AdminDepartment;
import com.origin.admin.entity.po.AdminDepartmentExample;

import java.util.List;

public interface AdminDepartmentMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(AdminDepartmentExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(AdminDepartment record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(AdminDepartment record);

    /**
     *
     * @mbg.generated
     */
    List<AdminDepartment> selectByExample(AdminDepartmentExample example);

    /**
     *
     * @mbg.generated
     */
    AdminDepartment selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AdminDepartment record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AdminDepartment record);
}
