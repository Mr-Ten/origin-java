package com.origin.admin.interceptors;

import com.origin.admin.annotation.PassToken;
import com.origin.admin.constants.ConstantUtil;
import com.origin.admin.filter.BusinessException;
import com.origin.admin.utils.TokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/10/12 15:47
 */
@Log4j2
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (!TokenUtil.isLogin(request)){
            throw new BusinessException(ConstantUtil.NO_LOGIN_ERROR);
        }
        return true;
    }

}
