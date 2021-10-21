package com.origin.admin.mapper.auto;

import com.origin.admin.entity.po.SysExcLogs;
import com.origin.admin.entity.po.SysExcLogsExample;
import java.util.List;

public interface SysExcLogsMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysExcLogsExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String excId);

    /**
     *
     * @mbg.generated
     */
    int insert(SysExcLogs record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysExcLogs record);

    /**
     *
     * @mbg.generated
     */
    List<SysExcLogs> selectByExample(SysExcLogsExample example);

    /**
     *
     * @mbg.generated
     */
    SysExcLogs selectByPrimaryKey(String excId);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SysExcLogs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysExcLogs record);
}