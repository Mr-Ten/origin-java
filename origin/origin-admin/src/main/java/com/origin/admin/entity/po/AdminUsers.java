package com.origin.admin.entity.po;

import com.baomidou.mybatisplus.annotation.*;
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
 * 后台管理员
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AdminUsers对象", description="后台管理员")
public class AdminUsers extends Model<AdminUsers> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户名称")
    private String nikeName;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像ID")
    private Long headsId;

    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "状态：1启用、0禁用")
    private Integer enable;

    @ApiModelProperty(value = "是否重复登陆（0:允许，1:不允许）")
    private Integer multiLogin;

    @ApiModelProperty(value = "最后登陆时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "注册时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "是否删除")
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
