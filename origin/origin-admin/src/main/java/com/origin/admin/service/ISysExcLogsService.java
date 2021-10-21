package com.origin.admin.service;

import com.origin.admin.entity.po.SysExcLogs;
import com.origin.admin.entity.po.SysExcLogsExample;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/7 00:20
 */
public interface ISysExcLogsService {

    List<SysExcLogs> findSysExcLog(SysExcLogsExample example);

    int insert(SysExcLogs sysExcLogs);
}
