package com.pazz.springboot.example.cache.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Peng Jian
 * @create: 2018/11/7 14:45
 * @description: 只读缓存存储
 */
public class StrongCacheStorage<K, V> implements ICacheStorage<K, V> {

    /**
     * 存储
     */
    private volatile Map<K, V> map;

    public StrongCacheStorage() {
        this.map = new ConcurrentHashMap<K, V>();
    }

    public void set(K key, V value) {
        map.put(key, value);
    }

    public void set(Map<K, V> values) {
        map = values;
    }

    public V get(K key) {
        return map.get(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void clear() {
        map.clear();
    }

    public Map<K, V> get() {
        return map;
    }

    public Boolean exists(K key) {
        return map.containsKey(key);
    }
}
