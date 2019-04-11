package com.pazz.springboot.redis.cache;

/**
 * @author: Peng Jian
 * @create: 2018/11/7 14:42
 * @description: Redis缓存接口
 */
public interface IRemoteCacheStorage<K, V> {

    /**
     * 主动向Cache更新指定的数据
     */
    boolean set(K key, V value);

    /**
     * 主动向Cache更新指定的数据,指定过期时间
     */
    boolean set(K key, V value, int exp);

    /**
     * 获取缓存
     */
    V get(K key);

}
