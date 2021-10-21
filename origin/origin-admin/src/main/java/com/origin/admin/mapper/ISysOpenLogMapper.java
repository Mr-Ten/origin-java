package com.origin.admin.mapper;

import com.origin.admin.entity.po.SysOperLogs;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/26 18:23
 */
public interface ISysOpenLogMapper {

    List<SysOperLogs> findOpenLog();
}
