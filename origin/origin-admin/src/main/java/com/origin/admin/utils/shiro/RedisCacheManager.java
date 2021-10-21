package com.origin.admin.utils.shiro;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * <pre>
 *
 * </pre>
 *
 * @author: tenglei
 * @date: 2021/7/30 13:35
 */
@Log4j2
public class RedisCacheManager implements CacheManager {

    /**
     * 参数：认证/授权魂穿的统一名称
     */
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) throws CacheException {
        log.info("RedisCacheManager.cacheName:{}",cacheName);
        return new RedisCache<K, V>(cacheName);
    }
}
