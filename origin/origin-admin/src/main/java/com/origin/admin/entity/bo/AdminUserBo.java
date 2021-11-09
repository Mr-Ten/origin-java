package com.origin.admin.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/18 20:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel(value = "管理员用户注册参数")
public class AdminUserBo {

    /**
     * 部门ID<br>
     * 列名:dept_id
     * 类型:VARCHAR(32)
     * 允许空:false
     * 缺省值:0
     */
    @ApiModelProperty(value = "部门ID")
    private Long deptId;

    /**
     * 登录账号<br>
     * 列名:account
     * 类型:VARCHAR(32)
     * 允许空:false
     * 缺省值:null
     */
    @ApiModelProperty(value = "登录账号")
    private String userName;

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
    private String nikeName;

    /**
     * 是否锁定(0:锁定，1:可用)<br>
     * 列名:status
     * 类型:BIT(1)
     * 允许空:false
     * 缺省值:null
     */
    @ApiModelProperty(value = "是否锁定(0:锁定，1:可用)")
    private Integer enable;

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
     * 备注<br>
     * 列名:remark
     * 类型:VARCHAR(255)
     * 允许空:true
     * 缺省值:null
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "头像ID")
    private String headsUrl;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "手机号码")
    private String phone;

}
