package com.pazz.springboot.redis.example.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:08
 * @description:
 */
public final class CacheManage<K, V> {

    private final static CacheManage INSTANCE = new CacheManage();

    private final Map<K, V> map = new HashMap<K, V>();

    private CacheManage(){}

    public static CacheManage getInstance() {
        return INSTANCE;
    }

    public void registerCacheProvider(){

    }
}
