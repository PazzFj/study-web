package com.pazz.study.redis.example.cache;

import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:11
 * @description:
 */
public interface ICache<K, V> extends ICacheId {

    V get(K key);

    Map<K, V> get();

}
