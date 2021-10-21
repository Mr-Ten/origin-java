package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.SysOperLogs;
import com.origin.admin.entity.po.SysOperLogsExample;

import java.util.List;

public interface SysOperLogsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysOperLogsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String operId);

    /**
     *
     * @mbg.generated
     */
    int insert(SysOperLogs record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysOperLogs record);

    /**
     *
     * @mbg.generated
     */
    List<SysOperLogs> selectByExample(SysOperLogsExample example);

    /**
     *
     * @mbg.generated
     */
    SysOperLogs selectByPrimaryKey(String operId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysOperLogs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysOperLogs record);
}
