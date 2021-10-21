package com.origin.admin.service;

import com.origin.admin.entity.po.SysOperLogs;
import com.origin.admin.entity.po.SysOperLogsExample;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/6 17:18
 */
public interface ISysOperLogService {

    List<SysOperLogs> findSysOperLogs(SysOperLogsExample example);

    int insert(SysOperLogs record);
}
