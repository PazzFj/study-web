package com.pazz.study.redis.example.cache.redis;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:17
 * @description:
 */
public interface ICacheStorage<K, V> {

    V get(K key);

    boolean set(K key, V value);

    boolean set(K key, V value, int exp);

}
