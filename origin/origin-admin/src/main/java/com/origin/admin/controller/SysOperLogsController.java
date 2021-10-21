package com.origin.admin.controller;

import com.origin.admin.entity.po.SysOperLogs;
import com.origin.admin.entity.po.SysOperLogsExample;
import com.origin.admin.service.ISysOperLogService;
import com.origin.admin.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/6 17:25
 */
@RestController
@RequestMapping("/api/sysOperLogs")
@Api(tags = "系统日志")
public class SysOperLogsController {

    @Autowired
    private ISysOperLogService iSysOperLogService;

    @RequestMapping(value = "/getOperLog", method = RequestMethod.GET)
    @ApiOperation(value = "获取日志列表", notes = "获取日志列表方法")
    //@OperLog(operModul = "系统日志", operType = "查询", operDesc = "查询操作日志")
    public Result getSysOperLogs(){
        SysOperLogsExample example = new SysOperLogsExample();
        List<SysOperLogs> sysOperLogs = iSysOperLogService.findSysOperLogs(example);
        return Result.success(sysOperLogs);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ApiOperation(value = "插入日志", notes = "插入日志方法")
    public Result insert(SysOperLogs logs){
        int insert = iSysOperLogService.insert(logs);
        return Result.success(insert);
    }
}
