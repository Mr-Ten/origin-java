package com.origin.admin.filter;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/19 21:21
 */
public class NotLoginException extends RuntimeException{
    public NotLoginException(){}
    public NotLoginException(String message){super(message);}
}
