package com.origin.admin.filter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.origin.admin.constants.ResultCode;
import com.origin.admin.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        return Result.error(ResultCode.SYSTEM_EXCEPTION, e.toString());
    }

    @ExceptionHandler(value = NotLoginException.class)
    public Result exceptionHandlerNotLogin(Exception e){
        return Result.error(ResultCode.NOT_LOGIN_ERROR, e.toString());
    }

    @ExceptionHandler(value = JWTDecodeException.class)
    public Result exceptionHandlerTokenError(Exception e){
        return Result.error(ResultCode.TOKEN_FORMAT_ERROR, e.toString());
    }
}
