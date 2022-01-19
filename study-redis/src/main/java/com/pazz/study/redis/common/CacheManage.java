package com.pazz.study.redis.common;

import com.pazz.study.redis.cache.ICache;
import com.pazz.study.redis.cache.exception.CacheConfigException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CacheManage<K, V> {

    private static final CacheManage INSTANCE = new CacheManage();

    private final Map<String, ICache<K, V>> uuidCaches = new ConcurrentHashMap<String, ICache<K, V>>();

    public static CacheManage getInstance() {
        return INSTANCE;
    }

    private CacheManage (){
    }

    public void registerCacheProvider(ICache<K, V> cache){
        String uuid = cache.getUUID();
        if(uuidCaches.containsKey(uuid)){
            throw new CacheConfigException("repetition 重复");
        }
        uuidCaches.put(uuid, cache);
    }

    public ICache<K, V> getCache(String uuid){
        ICache<K, V> cache = uuidCaches.get(uuid);
        if (cache == null) {
            throw new CacheConfigException("No register cache provider for cache UUID " + uuid);
        }
        return cache;
    }

}
