package com.origin.admin.entity.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 部门表
 * admin_department
 * @author: mrteng
 * @date: 2021-10-18 19:02:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "部门表对象")
public class AdminDepartment implements Serializable {
    /**
     * 部门标识<br> 
    * 列名:id
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "部门标识")
    private String id;

    /**
     * 部门名称<br> 
    * 列名:dept_name
    * 类型:VARCHAR(16)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 部门描述<br> 
    * 列名:desc
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "部门描述")
    private String desc;

    /**
     * 上级部门<br> 
    * 列名:parent_id
    * 类型:VARCHAR(32)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "上级部门")
    private String parentId;

    /**
     * 负责人<br> 
    * 列名:leader
    * 类型:VARCHAR(32)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "负责人")
    private String leader;

    /**
     * 部门级别<br> 
    * 列名:level
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "部门级别")
    private String level;

    /**
     * 排序<br> 
    * 列名:order
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "排序")
    private String order;

    /**
     * 有效状态<br> 
    * 列名:id_delect
    * 类型:VARCHAR(8)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "有效状态")
    private String idDelect;

    /**
     * 来源那个数据库<br> 
    * 列名:db_source
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:0
     */
    @ApiModelProperty(value = "来源那个数据库")
    private String dbSource;

    /**
     * admin_department
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public AdminDepartment(String id, String deptName, String desc, String parentId, String leader, String level, String order, String idDelect, String dbSource) {
        this.id = id;
        this.deptName = deptName;
        this.desc = desc;
        this.parentId = parentId;
        this.leader = leader;
        this.level = level;
        this.order = order;
        this.idDelect = idDelect;
        this.dbSource = dbSource;
    }

    /**
     *
     * @mbg.generated
     */
    public AdminDepartment() {
        super();
    }
}