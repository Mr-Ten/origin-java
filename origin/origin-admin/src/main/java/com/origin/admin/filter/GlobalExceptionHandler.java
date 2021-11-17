package com.origin.admin.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.origin.admin.constants.ResultCodeEnum;
import com.origin.admin.utils.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/7 23:22
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数绑定异常类 用于表单验证时抛出的异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public Result validatedBindException(BindException e){
        String message = "["+e.getAllErrors().get(0).getDefaultMessage()+"]";
        return Result.error(message);
    }

    /**
     * 系统异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        return Result.error(ResultCodeEnum.SERVICES_ERROR, e.toString());
    }

    /**
     * 拦截未知的运行时的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    public Result runtimeException(RuntimeException e){
        return Result.error(ResultCodeEnum.SYSTEM_EXCEPTION, e.toString());
    }

    @ExceptionHandler(value = JWTDecodeException.class)
    public Result exceptionHandlerTokenError(Exception e){
        return Result.error(ResultCodeEnum.TOKEN_FORMAT_ERROR, e.toString());
    }

    /**
     * 业务异常
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result businessException(HttpServletRequest request, BusinessException e){
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public Result sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        return Result.error(e.getMessage());
    }


}
