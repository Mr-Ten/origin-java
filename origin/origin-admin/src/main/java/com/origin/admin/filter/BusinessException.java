package com.origin.admin.filter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/11/10 18:54
 */
public class BusinessException extends RuntimeException{

    private String message;

    public BusinessException(String message){
        this.message = message;
    }

    public BusinessException(String message, Throwable e){
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
