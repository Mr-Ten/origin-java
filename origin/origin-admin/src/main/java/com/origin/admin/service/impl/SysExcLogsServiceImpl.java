package com.origin.admin.service.impl;

import com.origin.admin.entity.po.SysExcLogs;
import com.origin.admin.entity.po.SysExcLogsExample;
import com.origin.admin.mapper.auto.SysExcLogsMapper;
import com.origin.admin.service.ISysExcLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/7 00:21
 */
@Service
public class SysExcLogsServiceImpl implements ISysExcLogsService {

    @Autowired
    private SysExcLogsMapper sysExcLogsMapper;

    @Override
    public List<SysExcLogs> findSysExcLog(SysExcLogsExample example) {
        List<SysExcLogs> sysExcLogs = sysExcLogsMapper.selectByExample(example);
        return sysExcLogs;
    }

    @Override
    public int insert(SysExcLogs sysExcLogs) {
        int insert = sysExcLogsMapper.insert(sysExcLogs);
        return insert;
    }
}
