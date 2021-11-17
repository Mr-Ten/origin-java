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
 * @date: 2021/11/9 23:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel(value = "角色添加")
public class RoleBo {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "角色标识")
    private String identified;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态(0.启用 1.禁用)")
    private Integer enable;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
