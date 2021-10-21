package com.origin.admin.service.impl;

import com.origin.admin.entity.po.SysOperLogs;
import com.origin.admin.entity.po.SysOperLogsExample;
import com.origin.admin.mapper.auto.SysOperLogsMapper;
import com.origin.admin.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/6 17:18
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {

    @Autowired
    private SysOperLogsMapper sysOperLogsMapper;


    @Override
    public List<SysOperLogs> findSysOperLogs(SysOperLogsExample example) {
        List<SysOperLogs> sysOperLogs = sysOperLogsMapper.selectByExample(example);
        return sysOperLogs;
    }

    @Override
    public int insert(SysOperLogs record) {
        int insert = sysOperLogsMapper.insert(record);
        return insert;
    }
}
