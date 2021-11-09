package com.origin.admin.controller;

import com.origin.admin.annotation.OperLog;
import com.origin.admin.utils.Result;
import com.origin.admin.utils.redis.RedisUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/8/16 16:59
 */
@RestController
@RequestMapping("/api/test")
@Api(tags = "测试组")
public class TestController {

    @Autowired private RedisUtil redisUtil;

    /**
     * JSON数据测试
     */
    @PostMapping("/sayHello")
    public Result sayHello(@RequestBody Map<String, Object> request) {
        return Result.success(request);
    }
    /**
     * RequestParam 参数测试
     */
    @PostMapping("/params")
    @OperLog(operModul = "测试访问", operType = "请求获取", operDesc = "测试访问")
    public Result params(@RequestParam Integer a) {
        return Result.success(a);
    }
    /**
     * 无参测试
     */
    @GetMapping("/noArgs")
    @OperLog(operModul = "测试无参访问", operType = "请求获取", operDesc = "测试无参访问")
    public Result noArgs() {
        return Result.success();
    }

    /**
     * 特殊对象测试
     */
    @GetMapping("/callHttpServletRequest")
    public Result callHttpServletRequest(HttpServletRequest request) {
        return Result.success();
    }

    @GetMapping("/findFixUserTokens")
    public Result findFixUserTokens(String key){
        String keys = "AdminUser:token_"+key+"_*";
        System.out.println(keys);
        final Object o = redisUtil.getPrefixKey(keys);
        return Result.success(o);
    }

    @GetMapping("/findUserToken")
    @OperLog(operModul = "测试参数访问", operDesc = "测试参数访问", operType = "请求获取")
    public Result findUserTokens(String key){
        final Object o = redisUtil.get(key);
        return Result.success(o);
    }

    @GetMapping("/findUserTokensBoolean")
    public Result findUserTokensBoolean(String key){
        Boolean isUser = redisUtil.exists(key);
        return Result.success(isUser);
    }

    @GetMapping("/findAllToken")
    public Result findAllToken(){
        final Set<String> keys = redisUtil.keys();
        return Result.success(keys);
    }

    @PostMapping("/errorTest")
    public Result errorTest(){
        int i = 1/0;
        return Result.success();
    }

    @PostMapping("/errorParamTest")
    public Result errorParamTest(Integer z, Integer m, String salt){
        Integer i = z/m;
        return Result.success(salt);
    }

}
