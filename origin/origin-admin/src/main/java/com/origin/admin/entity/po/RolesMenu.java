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
 * 角色权限关联表
 * </p>
 *
 * @author MrTen
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RolesMenu对象", description="角色权限关联表")
public class RolesMenu extends Model<RolesMenu> {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long meunId;


    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

}
