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
 * 异常日志表
 * sys_exc_logs
 * @author: mrteng
 * @date: 2021-10-19 22:36:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "异常日志表对象")
public class SysExcLogs implements Serializable {
    /**
     * 主键ID<br> 
    * 列名:exc_id
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "主键ID")
    private String excId;

    /**
     * 请求参数<br> 
    * 列名:exc_requ_param
    * 类型:VARCHAR(65535)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "请求参数")
    private String excRequParam;

    /**
     * 异常名称<br> 
    * 列名:exc_name
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "异常名称")
    private String excName;

    /**
     * 异常信息<br> 
    * 列名:exc_message
    * 类型:VARCHAR(65535)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "异常信息")
    private String excMessage;

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
     * 请求时间<br> 
    * 列名:exc_requ_time
    * 类型:VARCHAR(32)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "请求时间")
    private String excRequTime;

    /**
     * 操作时间<br> 
    * 列名:exc_create_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "操作时间")
    private Date excCreateTime;

    /**
     * sys_exc_logs
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public SysExcLogs(String excId, String excRequParam, String excName, String excMessage, String operUserId, String operUserName, String operMethod, String operUri, String operIp, String excRequTime, Date excCreateTime) {
        this.excId = excId;
        this.excRequParam = excRequParam;
        this.excName = excName;
        this.excMessage = excMessage;
        this.operUserId = operUserId;
        this.operUserName = operUserName;
        this.operMethod = operMethod;
        this.operUri = operUri;
        this.operIp = operIp;
        this.excRequTime = excRequTime;
        this.excCreateTime = excCreateTime;
    }

    /**
     *
     * @mbg.generated
     */
    public SysExcLogs() {
        super();
    }
}