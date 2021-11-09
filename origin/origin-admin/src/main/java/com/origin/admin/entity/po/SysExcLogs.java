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
 * 异常日志表
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysExcLogs对象", description="异常日志表")
public class SysExcLogs extends Model<SysExcLogs> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "exc_id")
    private String excId;

    @ApiModelProperty(value = "请求参数")
    private String excRequParam;

    @ApiModelProperty(value = "异常名称")
    private String excName;

    @ApiModelProperty(value = "异常信息")
    private String excMessage;

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

    @ApiModelProperty(value = "请求时间")
    private String excRequTime;

    @ApiModelProperty(value = "操作时间")
    private Date excCreateTime;


    @Override
    protected Serializable pkVal() {
        return this.excId;
    }

}
