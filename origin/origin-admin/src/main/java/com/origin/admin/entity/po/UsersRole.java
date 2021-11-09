package com.origin.admin.entity.po;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户角色关联
 * </p>
 *
 * @author MrTen
 * @since 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UsersRole对象", description="用户角色关联")
public class UsersRole extends Model<UsersRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "管理员用户ID")
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
