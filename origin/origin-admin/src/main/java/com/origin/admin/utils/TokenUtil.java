package com.origin.admin.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.origin.admin.constants.ConstantUtil;
import com.origin.admin.utils.redis.RedisUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * <pre>
 * 获取Token
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/9/29 23:50
 */
@Log4j2
@Component
public class TokenUtil {

    private static RedisUtil redisUtil;
    private static WebApplicationContext ctx;

    /**
     * token失效时间（秒）
     */
    private static final Integer TOKEN_TIMEOUT_SECONDS = 3600 * 24;

    /**
     * 生成token的私钥
     */
    private static final String TOKEN_PRIVATE_KEY = "1D53BD21-0EC8-46F9-B14F-10D2145C1F4D";

    /**
     * token Redis Key的前缀
     */
    public static final String REDIS_TOKEN_KEY_PREFIX = "token_";

    @Autowired
    public TokenUtil(WebApplicationContext ctx){
        TokenUtil.ctx = ctx;
        TokenUtil.redisUtil = TokenUtil.ctx.getBean(RedisUtil.class);
    }

    /**
     * 获取token
     * @param account 登陆账号
     * @param password 登陆密码
     * @return 返回string类型token
     */
    public static String getToken(String account, String password){
        String token;
        //过期时间
        Date date = new Date(System.currentTimeMillis()+TOKEN_TIMEOUT_SECONDS);
        //密钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_PRIVATE_KEY);

        Map<String, Object> header = new HashMap<String, Object>();
        header.put("type", "jwt");
        header.put("alg", "HS256");

        token = JWT.create()
                .withHeader(header)
                .withClaim("account", account)
                .withClaim("password", password)
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token，通过返回true
     * @param token
     * @return
     */
    public static Boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_PRIVATE_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT verify = verifier.verify(token);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 从token中解析账号
     * @param token
     * @return
     */
    public static String resolveAccountFromToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_PRIVATE_KEY);
        final JWTVerifier build = JWT.require(algorithm).build();
        return build.verify(token).getClaim("account").asString();
    }

    public static String resolveAccountFromToken(){
        return resolveAccountFromToken(getRequestToken());
    }

    /**
     * 添加token到redis中
     * @param account 用户登陆账号
     * @param password 用户密码
     * @param multiLogin 是否允许多登陆
     * @return
     */
    public static String addTokenToRedis(String account, String password, Integer multiLogin){
        boolean isMultiLogin = multiLogin != null && multiLogin == 1;
        String token = getToken(account, password);

        String key = "AdminUser:" + REDIS_TOKEN_KEY_PREFIX + account+"_";
        Set<String> keySet = redisUtil.getPrefixKey(key + "*");
        //不允许重复登陆
        if(isMultiLogin && keySet.size() > 0){
            redisUtil.delete(keySet);
        }
        //把新生成的token存入redis
        redisUtil.set(key+System.currentTimeMillis(), token, TOKEN_TIMEOUT_SECONDS);
        return token;
    }

    /**
     * 从request中获取token
     * @return
     */
    public static String getRequestToken(){
        return getRequestToken(getRequest());
    }

    public static String getRequestToken(HttpServletRequest request){
        String token = request.getHeader(ConstantUtil.TOKEN);
        if (StringUtils.isBlank(token)){
            token = (String) request.getAttribute(ConstantUtil.TOKEN);
        }
        return  token;
    }

    /**
     * 获取request
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    /**
     * 验证是否登陆
     * @param request
     * @return true：已登陆； false：未登陆
     */
    public static Boolean isLogin(HttpServletRequest request){
        String token = getRequestToken(request);
        if(StringUtils.isBlank(token)){
            return false;
        }
        String account = resolveAccountFromToken(token);
        final List<String> tokenFromRedis = getTokenFromRedis(account);
        return tokenFromRedis.contains(token);
    }

    /**
     * 查询账号下所有在redis中的token
     * @param account
     * @return
     */
    public static List<String> getTokenFromRedis(String account){
        List<String> result = new ArrayList<String>();
        String key = "AdminUser:"+REDIS_TOKEN_KEY_PREFIX+account+"_";
        Set<String> prefixKey = redisUtil.getPrefixKey(key + "*");
        prefixKey.forEach(item -> result.add(redisUtil.getKeyByValue(item)));
        return  result;
    }

    public static Set<String> getKeyFromToken(String account){
        String key = "AdminUser:"+REDIS_TOKEN_KEY_PREFIX+account+"_";
        final Set<String> prefixKey = redisUtil.getPrefixKey(key + "*");
        return prefixKey;
    }

    public static Boolean removeTokenRedis(){
        final String requestToken = getRequestToken();
        final String account = resolveAccountFromToken(requestToken);
        final Set<String> prefixKey = getKeyFromToken(account);
        boolean isMultiLogin = true;
        if (true){
            //允许多登陆
            prefixKey.forEach(item -> {
                String token = redisUtil.getKeyByValue(item);
                if(StringUtils.equals(token, requestToken)){
                    redisUtil.delete(item);
                }
            });
        }else {
            //不允许多登陆，清空所有token
            redisUtil.delete(prefixKey);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String code = "eyJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImFjY291bnQiOiJ0ZW5nbGVpIn0.qavRa6ql2hXILqqiMhhrVxlRaRSmahvupcaBT1BiK70";

        System.out.println(resolveAccountFromToken(code));
    }
}
