package com.pazz.springboot.redis.example.cache;

import com.pazz.springboot.redis.example.cache.exception.CacheConfigException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:08
 * @description:
 */
public final class CacheManage<K, V> {

    private final static CacheManage INSTANCE = new CacheManage();

    private final Map<String, ICache<K, V>> uuidCaches = new HashMap<String, ICache<K, V>>();

    private CacheManage(){}

    public static CacheManage getInstance() {
        return INSTANCE;
    }

    public void registerCacheProvider(ICache<K, V> cache){ //cache 当前缓存的实例对象
        String uuid = cache.getUUID();
        if(uuidCaches.containsKey(uuid)){
            throw new CacheConfigException("Dumplicate uuid " + uuid + " to cache provider " + cache.getClass().getName() + " and " + uuidCaches.get(uuid).getClass().getName());
        }
        uuidCaches.put(uuid, cache);
    }

    public ICache<K, V> getCache(String uuid){  //类名对应的缓存实例
        ICache<K, V> cache = uuidCaches.get(uuid);
        if(cache == null){
            throw new CacheConfigException("No register cache provider for cache UUID " + uuid);
        }
        return cache;
    }
}
