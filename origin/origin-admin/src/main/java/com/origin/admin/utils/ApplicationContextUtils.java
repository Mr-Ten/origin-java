package com.origin.admin.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 用来获取springboot创建好的工厂
 * 此类必须交给springboot管理
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/16 12:08
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

     /** 将创建好工厂以参数形式传递给这个类 */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

     /** 根据类在工厂的唯一id从spring容器中获取javabean */
    public static Object getBeanById(String beanName) {
        return applicationContext.getBean(beanName);
    }

    /** 根据class的名字从spring容器中获取javabean */
    public static <T> T getBeanByName(Class<T> targetClass) {
        return applicationContext.getBean(targetClass);
    }
}
