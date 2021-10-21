package com.origin.admin.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 操作日志表
 * sys_oper_logs
 * @author: mrteng
 * @date: 2021-10-18 19:02:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "操作日志表对象")
public class SysOperLogs implements Serializable {
    /**
     * 主键ID<br> 
    * 列名:oper_id
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "主键ID")
    private String operId;

    /**
     * 功能模块<br> 
    * 列名:oper_modul
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "功能模块")
    private String operModul;

    /**
     * 操作类型<br> 
    * 列名:oper_type
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作类型")
    private String operType;

    /**
     * 操作描述<br> 
    * 列名:oper_desc
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    /**
     * 请求参数<br> 
    * 列名:oper_requ_param
    * 类型:VARCHAR(65535)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "请求参数")
    private String operRequParam;

    /**
     * 返回参数<br> 
    * 列名:oper_resq_param
    * 类型:VARCHAR(2147483647)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "返回参数")
    private String operResqParam;

    /**
     * 操作人ID<br> 
    * 列名:oper_user_id
    * 类型:VARCHAR(32)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作人ID")
    private String operUserId;

    /**
     * 操作人名称<br> 
    * 列名:oper_user_name
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作人名称")
    private String operUserName;

    /**
     * 操作方法<br> 
    * 列名:oper_method
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作方法")
    private String operMethod;

    /**
     * 请求地址<br> 
    * 列名:oper_uri
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "请求地址")
    private String operUri;

    /**
     * 操作人IP<br> 
    * 列名:oper_ip
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作人IP")
    private String operIp;

    /**
     * 操作时间<br> 
    * 列名:oper_create_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作时间")
    private Date operCreateTime;

    /**
     * 请求时长<br> 
    * 列名:oper_requ_time
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "请求时长")
    private String operRequTime;

    /**
     * sys_oper_logs
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public SysOperLogs(String operId, String operModul, String operType, String operDesc, String operRequParam, String operResqParam, String operUserId, String operUserName, String operMethod, String operUri, String operIp, Date operCreateTime, String operRequTime) {
        this.operId = operId;
        this.operModul = operModul;
        this.operType = operType;
        this.operDesc = operDesc;
        this.operRequParam = operRequParam;
        this.operResqParam = operResqParam;
        this.operUserId = operUserId;
        this.operUserName = operUserName;
        this.operMethod = operMethod;
        this.operUri = operUri;
        this.operIp = operIp;
        this.operCreateTime = operCreateTime;
        this.operRequTime = operRequTime;
    }

    /**
     *
     * @mbg.generated
     */
    public SysOperLogs() {
        super();
    }
}