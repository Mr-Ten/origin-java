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
 * 权限表
 * admin_permission
 * @author: mrteng
 * @date: 2021-10-18 19:02:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "权限表对象")
public class AdminPermission implements Serializable {
    /**
     * <br> 
    * 列名:id
    * 类型:INTEGER(10)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "")
    private Integer id;

    /**
     * 角色ID<br> 
    * 列名:role_id
    * 类型:INTEGER(10)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    /**
     * 权限<br> 
    * 列名:permission
    * 类型:VARCHAR(63)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "权限")
    private String permission;

    /**
     * 创建时间<br> 
    * 列名:add_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "创建时间")
    private Date addTime;

    /**
     * 更新时间<br> 
    * 列名:update_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 逻辑删除<br> 
    * 列名:deleted
    * 类型:BIT(1)
    * 允许空:true
    * 缺省值:0
     */
    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;

    /**
     * admin_permission
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public AdminPermission(Integer id, Integer roleId, String permission, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.roleId = roleId;
        this.permission = permission;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    /**
     *
     * @mbg.generated
     */
    public AdminPermission() {
        super();
    }
}