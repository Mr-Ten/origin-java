package com.origin.admin.utils;

import com.origin.admin.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/25 16:39
 */
@Data
@Builder
@Accessors(chain = true)
@ApiModel(value = "全局的统一返回结果")
public class Result implements Serializable {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Object data;

    @ApiModelProperty(value = "时间戳")
    private Date timeTemp;

    public static Result success(){
        return Result.builder().success(true)
                .code(ResultCodeEnum.SUCCESS.code())
                .message(ResultCodeEnum.SUCCESS.message())
                .timeTemp(new Date()).build();
    }

    public static Result success(ResultCodeEnum resultCodeEnum){
        return Result.builder().success(true)
                .code(resultCodeEnum.code())
                .message(resultCodeEnum.message())
                .timeTemp(new Date()).build();
    }

    public static Result success(Object data){
        return Result.builder().success(true)
                .code(ResultCodeEnum.SUCCESS.code())
                .message(ResultCodeEnum.SUCCESS.message())
                .data(data)
                .timeTemp(new Date()).build();
    }


    public static Result error(ResultCodeEnum resultCodeEnum, Object exception){
        return Result.builder().success(false)
                .code(resultCodeEnum.code())
                .message(resultCodeEnum.message())
                .data(exception)
                .timeTemp(new Date()).build();
    }

    public static Result error(ResultCodeEnum resultCodeEnum){
        return Result.builder().success(false)
                .code(resultCodeEnum.code())
                .message(resultCodeEnum.message())
                .timeTemp(new Date()).build();
    }

    public static Result error(String message){
        return Result.builder().success(false)
                .code(-1)
                .message(message)
                .timeTemp(new Date()).build();
    }
}
