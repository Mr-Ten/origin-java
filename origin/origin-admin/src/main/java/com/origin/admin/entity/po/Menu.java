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
 * 菜单权限表
 * </p>
 *
 * @author MrTen
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Menu对象", description="菜单权限表")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "上级ID")
    private Long pid;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "组件地址")
    private String component;

    @ApiModelProperty(value = "组件名称")
    private String componentName;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "权限")
    private String permission;

    @ApiModelProperty(value = "排序")
    private Long sort;

    @ApiModelProperty(value = "类型(0.菜单 1.按钮 )")
    private Integer type;

    @ApiModelProperty(value = "状态(0.禁用 1.正常 2.隐藏)")
    private Long status;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "版本")
    @Version
    private String version;

    @ApiModelProperty(value = "是否删除")
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
