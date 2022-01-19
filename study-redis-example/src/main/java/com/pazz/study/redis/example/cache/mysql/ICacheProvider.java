package com.pazz.study.redis.example.cache.mysql;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:44
 * @description:
 */
public interface ICacheProvider<V> {

    V get(String key);

}
