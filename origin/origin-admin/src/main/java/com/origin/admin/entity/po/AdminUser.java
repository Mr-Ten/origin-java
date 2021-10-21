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
 * 管理员用户表
 * admin_user
 * @author: mrteng
 * @date: 2021-10-19 22:36:11
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "管理员用户表对象")
public class AdminUser implements Serializable {
    /**
     * 用户ID <br> 
    * 列名:user_id
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:0
     */
    @ApiModelProperty(value = "用户ID ")
    private String userId;

    /**
     * 部门ID<br> 
    * 列名:dept_id
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:0
     */
    @ApiModelProperty(value = "部门ID")
    private String deptId;

    /**
     * 登录账号<br> 
    * 列名:account
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "登录账号")
    private String account;

    /**
     * 登录密码<br> 
    * 列名:password
    * 类型:VARCHAR(128)
    * 允许空:false
    * 缺省值:0
     */
    @ApiModelProperty(value = "登录密码")
    private String password;

    /**
     * 用户姓名<br> 
    * 列名:user_name
    * 类型:VARCHAR(32)
    * 允许空:false
    * 缺省值:null
     */
    @ApiModelProperty(value = "用户姓名")
    private String userName;

    /**
     * 是否锁定(0:锁定，1:可用)<br> 
    * 列名:status
    * 类型:BIT(1)
    * 允许空:false
    * 缺省值:1
     */
    @ApiModelProperty(value = "是否锁定(0:锁定，1:可用)")
    private Boolean status;

    /**
     * 电子邮件<br> 
    * 列名:email
    * 类型:VARCHAR(64)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "电子邮件")
    private String email;

    /**
     * 创建时间<br> 
    * 列名:create_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 登录时间<br> 
    * 列名:login_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "登录时间")
    private Date loginTime;

    /**
     * 最后登录时间<br> 
    * 列名:last_login_time
    * 类型:TIMESTAMP(19)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "最后登录时间")
    private Date lastLoginTime;

    /**
     * 登录次数<br> 
    * 列名:login_count
    * 类型:INTEGER(10)
    * 允许空:true
    * 缺省值:0
     */
    @ApiModelProperty(value = "登录次数")
    private Integer loginCount;

    /**
     * 备注<br> 
    * 列名:remark
    * 类型:VARCHAR(255)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 盐<br> 
    * 列名:salt
    * 类型:VARCHAR(32)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "盐")
    private String salt;

    /**
     * 联系电话<br> 
    * 列名:tel
    * 类型:VARCHAR(16)
    * 允许空:true
    * 缺省值:null
     */
    @ApiModelProperty(value = "联系电话")
    private String tel;

    /**
     * 是否重复登陆（0:允许，1:不允许）<br> 
    * 列名:multi_login
    * 类型:BIT(1)
    * 允许空:true
    * 缺省值:0
     */
    @ApiModelProperty(value = "是否重复登陆（0:允许，1:不允许）")
    private Boolean multiLogin;

    /**
     * admin_user
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public AdminUser(String userId, String deptId, String account, String password, String userName, Boolean status, String email, Date createTime, Date loginTime, Date lastLoginTime, Integer loginCount, String remark, String salt, String tel, Boolean multiLogin) {
        this.userId = userId;
        this.deptId = deptId;
        this.account = account;
        this.password = password;
        this.userName = userName;
        this.status = status;
        this.email = email;
        this.createTime = createTime;
        this.loginTime = loginTime;
        this.lastLoginTime = lastLoginTime;
        this.loginCount = loginCount;
        this.remark = remark;
        this.salt = salt;
        this.tel = tel;
        this.multiLogin = multiLogin;
    }

    /**
     *
     * @mbg.generated
     */
    public AdminUser() {
        super();
    }
}