package com.pazz.springboot.redis.cache;

import com.pazz.springboot.redis.cache.exception.CacheConfigException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: 彭坚
 * @create: 2018/11/28 14:17
 * @description:
 */
public final class CacheManager<K, V> {

    private static final CacheManager CACHE_MANAGER = new CacheManager();

    /**
     * 保存所有缓存实例
     */
    private final Map<String, ICache<K, V>> uuidCaches = new ConcurrentHashMap<String, ICache<K, V>>();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return CACHE_MANAGER;
    }

    public void registerCacheProvider(ICache<K, V> cache) {
        // 不允许UUID重复，应用必须在实现的Cache接口确保命名不重复
        String uuid = cache.getUUID();
        if (uuidCaches.containsKey(uuid)) {
            throw new CacheConfigException("Duplicate uuid " + uuid + " to cache provider " + cache.getClass().getName() + " and " + uuidCaches.get(uuid).getClass().getName());
        }
        uuidCaches.put(uuid, cache);
    }

    /**
     * 根据uuid获取缓存实例
     */
    public ICache<K, V> getCache(String uuid) {
        ICache<K, V> cache = uuidCaches.get(uuid);
        if (cache == null) {
            throw new CacheConfigException("No register cache provider for cache UUID " + uuid);
        }
        return cache;
    }

    public void shutdown() {
        uuidCaches.clear();
    }

}
