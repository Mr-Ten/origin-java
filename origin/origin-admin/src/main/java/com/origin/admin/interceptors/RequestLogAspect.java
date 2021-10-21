package com.origin.admin.interceptors;

import com.alibaba.fastjson.JSON;
import com.origin.admin.annotation.OperLog;
import com.origin.admin.entity.po.SysExcLogs;
import com.origin.admin.entity.po.SysOperLogs;
import com.origin.admin.service.ISysExcLogsService;
import com.origin.admin.service.ISysOperLogService;
import com.origin.admin.utils.IPUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/26 21:36
 */
@Component
@Aspect
@Slf4j
public class RequestLogAspect {

    private static ThreadLocal<SysOperLogs> threadLocal = new ThreadLocal<SysOperLogs>();
    private Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);
    @Autowired private ISysOperLogService iSysOperLogService;
    @Autowired private ISysExcLogsService iSysExcLogsService;

    @Value("${version}")
    private String operVersion;

    @Pointcut("@annotation(com.origin.admin.annotation.OperLog)")
    public void operLogPointcut(){}

    @Pointcut("execution(* com.origin.admin.controller..*.*(..)) ")
    public void excLogPointcut(){}

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("operLogPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //TODO: 添加响应时间，毫秒
        logger.info("调用{}版本controller花费时间time = {}ms", operVersion,(end-start));
        return  result;
    }

    /**
     * 前置通知:在某个连接点之前执行，除非出现异常不然不能阻止连接点的执行
     * @param joinPoint
     */
    @Before("operLogPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        // 1.收到请求，记录请求内容
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 2.获取请求方法的类名
        String beanName = joinPoint.getSignature().getDeclaringTypeName();
        // 3.获取请求的方法
        Method method = signature.getMethod();
        // 4.获取注解参数值
        ApiOperation annotation = signature.getMethod().getAnnotation(ApiOperation.class);
        // 打印日志
        logger.info("  TypeName  : {}" , beanName);
        logger.info(" MethodName : {}" , method.getName());
        logger.info("  U  R  L   : {}" , request.getServletPath());
        logger.info("HTTP_METHOD : {}" , request.getMethod());
        logger.info("    I P     : {}" , request.getRemoteAddr());
        //TODO: 添加到操作日志表
    }

    /**
     * 某连接点退出的时候执行的通知
     */
    @After("operLogPointcut()")
    public void doAfter(){}

    /**
     * 返回后通知：某个连接点正常完成后执行的通知
     * @param keys
     */
    @AfterReturning(value = "operLogPointcut()", returning = "keys")
    public void doAfterReturning(JoinPoint joinPoint, Object keys) {
        logger.info("RESPONSE: "+keys);
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);

        SysOperLogs operlog = new SysOperLogs();
        try {
            operlog.setOperId(UUID.randomUUID().toString().replace("-","")); // 主键ID

            // 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            // 获取切入点所在的方法
            Method method = signature.getMethod();
            // 获取操作
            OperLog opLog = method.getAnnotation(OperLog.class);
            if (opLog != null) {
                String operModul = opLog.operModul();
                String operType = opLog.operType();
                String operDesc = opLog.operDesc();
                operlog.setOperModul(operModul); // 操作模块
                operlog.setOperType(operType); // 操作类型
                operlog.setOperDesc(operDesc); // 操作描述
            }
            // 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;

            operlog.setOperMethod(methodName); // 请求方法

            // 请求的参数
            Map rtnMap = request.getParameterMap();// 将参数所在的数组转换成json
            String params = JSON.toJSONString(request.getParameterMap());
            operlog.setOperRequParam(params); // 请求参数
            System.out.println("request.getMethod():"+request.getMethod());
            System.out.println("RequestMethod.GET:"+RequestMethod.GET);
            if (!request.getMethod().equals(RequestMethod.GET)){
                operlog.setOperResqParam(JSON.toJSONString(keys)); // 返回结果
            }
            operlog.setOperUserId(String.valueOf(System.currentTimeMillis())); // 请求用户ID
            operlog.setOperUserName("tenglei"); // 请求用户名称
            operlog.setOperIp(IPUtil.getRemortIP(request)); // 请求IP
            operlog.setOperUri(request.getRequestURI()); // 请求URI
            operlog.setOperCreateTime(new Date()); // 创建时间
            iSysOperLogService.insert(operlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常增强
     * @param e
     * @param joinPoint
     */
    @AfterThrowing(pointcut = "excLogPointcut()", throwing = "e")
    public void logThrowing(JoinPoint joinPoint, Throwable e) {

        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();// 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes
                .resolveReference(RequestAttributes.REFERENCE_REQUEST);
        SysExcLogs excepLog = new SysExcLogs();
        try {// 从切面织入点处通过反射机制获取织入点处的方法
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();// 获取切入点所在的方法
            Method method = signature.getMethod();
            excepLog.setExcId(UUID.randomUUID().toString().replace("-",""));// 获取请求的类名
            String className = joinPoint.getTarget().getClass().getName();// 获取请求的方法名
            String methodName = method.getName();
            methodName = className + "." + methodName;// 请求的参数
            Map rtnMap = converMap(request.getParameterMap());// 将参数所在的数组转换成json
            String params = JSON.toJSONString(rtnMap);
            excepLog.setExcRequParam(params); // 请求参数
            excepLog.setOperMethod(methodName); // 请求方法名
            excepLog.setExcName(e.getClass().getName()); // 异常名称
            excepLog.setExcMessage(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace())); // 异常信息
            excepLog.setOperUserId(String.valueOf(System.currentTimeMillis())); // 操作员ID
            excepLog.setOperUserName("tenglei"); // 操作员名称
            excepLog.setOperUri(request.getRequestURI()); // 操作URI
            excepLog.setOperIp(IPUtil.getRemortIP(request)); // 操作员IP
            excepLog.setExcCreateTime(new Date()); // 发生异常时间
            iSysExcLogsService.insert(excepLog);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /**
     * 转换request 请求参数
     * @param paramMap
     * @return
     */
    public Map converMap(Map paramMap) {
        Map rtnMap = new HashMap();
        for (Object key : paramMap.keySet()) {
            //rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

    /**
     * 转换异常信息为字符串
     * @param exceptionName
     * @param exceptionMessage
     * @param elements
     * @return
     */
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();for (StackTraceElement stet : elements) {
            strbuff.append(stet + "\n");
        }
        String message = exceptionName + ":" + exceptionMessage + "\n\t" + strbuff.toString();return message;
    }
}
