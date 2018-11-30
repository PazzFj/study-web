package com.pazz.springboot.example.cache.util;

import com.pazz.springboot.example.cache.IFunctionCache;
import com.pazz.springboot.example.cache.IUserCache;
import com.pazz.springboot.example.holder.WebApplicationContextHolder;
import org.springframework.util.StringUtils;

/**
 * @author: Peng Jian
 * @create: 2018/11/8 9:50
 * @description: Cache工具类
 */
public class CacheUtil {

    private static String userCacheId = null;
    private static String functionCacheId = null;

    public static String getUserCacheId() {
        if (!StringUtils.isEmpty(userCacheId)) {
            return userCacheId;
        }
        IUserCache userCache = WebApplicationContextHolder.getWebApplicationContext().getBean(IUserCache.class);
        userCacheId = userCache.getClass().getName();
        return userCacheId;
    }

    public static String getFunctionCacheId() {
        if (!StringUtils.isEmpty(functionCacheId)) {
            return functionCacheId;
        }
        IFunctionCache functionCache = WebApplicationContextHolder.getWebApplicationContext().getBean(IFunctionCache.class);
        functionCacheId = functionCache.getClass().getName();
        return functionCacheId;
    }
}
