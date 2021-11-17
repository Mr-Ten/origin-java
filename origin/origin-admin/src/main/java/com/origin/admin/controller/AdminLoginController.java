package com.origin.admin.controller;

import cn.hutool.core.lang.Assert;
import com.origin.admin.constants.ConstantUtil;
import com.origin.admin.constants.ResultCodeEnum;
import com.origin.admin.utils.Result;
import com.origin.admin.utils.TokenUtil;
import com.origin.admin.utils.VerifyCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/14 23:44
 */
@RestController
@RequestMapping("/")
@Api(tags = "管理员登陆")
@Log4j2
public class AdminLoginController {

    @Value("${captcha.enable}")
    private Boolean captchaEnable;

    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    @ApiOperation(value = "获取验证码")
    public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置不缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //获取验证码
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //验证码写入session
        request.getSession().setAttribute(ConstantUtil.ADMIN_LOGIN_VERIFY_CODE, verifyCode);
        log.info("本次验证码为：{}, 已存入HttpSession中", verifyCode);
        response.setContentType("image/png");
        //验证码写入流
        VerifyCodeUtils.outputImage(600, 200, response.getOutputStream(), verifyCode);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "管理员登陆", notes = "管理员登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "用户账号", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", dataType = "String"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "String")
    })
    public Result login(String account, String password, String code, HttpServletRequest request){
        Assert.notBlank(account, ConstantUtil.ACCOUNT_NOT_NULL);
        Assert.notBlank(password, ConstantUtil.PASSWORD_NO_NULL);
        if (captchaEnable){
            Assert.notBlank(code, ConstantUtil.CAPTCHA_NO_NULL);
            String getSessionCode = (String) request.getSession().getAttribute(ConstantUtil.ADMIN_LOGIN_VERIFY_CODE);
            log.info("获取到HttpSession的验证码：{}", getSessionCode);
            if(!StringUtils.equalsIgnoreCase(getSessionCode, code)){
                request.getSession().removeAttribute(ConstantUtil.ADMIN_LOGIN_VERIFY_CODE);
                return Result.error(ResultCodeEnum.AUTH_CAPTCHA_ERROR);
            }
            request.getSession().removeAttribute(ConstantUtil.ADMIN_LOGIN_VERIFY_CODE);
        }
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(account, password));
            String getToken = TokenUtil.addTokenToRedis(account, password, 0);
            return Result.success(getToken);
        } catch (UnknownAccountException e){
            return Result.error(ResultCodeEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e){
            return Result.error(ResultCodeEnum.INCORRECT_CREDENTIALS);
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ApiOperation(value = "管理员退出", notes = "管理员退出")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            TokenUtil.removeTokenRedis();
        }
        return Result.success();
    }
}
