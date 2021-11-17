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
 * @date: 2021/11/17 21:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@ApiModel(value = "媒体资源上传")
public class ResourceBo {

    @ApiModelProperty(value = "类型（0.图片，1.视频）")
    private Integer type;

    @ApiModelProperty(value = "资源地址")
    private String path;

    @ApiModelProperty(value = "存放位置（0.本地，1.）")
    private Integer location;
}
