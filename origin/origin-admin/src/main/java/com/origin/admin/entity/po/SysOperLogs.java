package com.origin.admin.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 操作日志表
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysOperLogs对象", description="操作日志表")
public class SysOperLogs extends Model<SysOperLogs> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "oper_id")
    private String operId;

    @ApiModelProperty(value = "功能模块")
    private String operModul;

    @ApiModelProperty(value = "操作类型")
    private String operType;

    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    @ApiModelProperty(value = "请求参数")
    private String operRequParam;

    @ApiModelProperty(value = "返回参数")
    private String operResqParam;

    @ApiModelProperty(value = "操作人ID")
    private String operUserId;

    @ApiModelProperty(value = "操作人名称")
    private String operUserName;

    @ApiModelProperty(value = "操作方法")
    private String operMethod;

    @ApiModelProperty(value = "请求地址")
    private String operUri;

    @ApiModelProperty(value = "操作人IP")
    private String operIp;

    @ApiModelProperty(value = "操作时间")
    private Date operCreateTime;

    @ApiModelProperty(value = "请求时长")
    private String operRequTime;


    @Override
    protected Serializable pkVal() {
        return this.operId;
    }

}
