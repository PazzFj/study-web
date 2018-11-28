package com.pazz.springboot.redis.util;

/**
 * 缓存KEY拼接工具类
 **/
public class CacheKeyJoinUtil {
    /**
     * 拼接符号
     */
    private static final String JOIN_SYMBOL = "#";

    /**
     * 拼接缓存key
     */
    public static String joinCacheKey(String... params){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< params.length; i++){
            sb.append(params[i]);
            if(i < params.length - 1){
                sb.append(JOIN_SYMBOL);
            }
        }
        return sb.toString();
    }

    public static String[] splitCacheKey(String cacheKey){
        return cacheKey.split(JOIN_SYMBOL);
    }

}
