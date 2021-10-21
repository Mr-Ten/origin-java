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
 * 角色表
 * admin_role
 * @author: mrteng
 * @date: 2021-10-18 19:02:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "角色表对象")
public class AdminRole implements Serializable {
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
     * 角色名称<br> 
    * 列名:name
    * 类型:VARCHAR(63)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "角色名称")
    private String name;

    /**
     * 角色描述<br> 
    * 列名:desc
    * 类型:VARCHAR(1023)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "角色描述")
    private String desc;

    /**
     * 是否启用<br> 
    * 列名:enabled
    * 类型:BIT(1)
    * 允许空:true
    * 缺省值:1
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

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
     * admin_role
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public AdminRole(Integer id, String name, String desc, Boolean enabled, Date addTime, Date updateTime, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.enabled = enabled;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    /**
     *
     * @mbg.generated
     */
    public AdminRole() {
        super();
    }
}