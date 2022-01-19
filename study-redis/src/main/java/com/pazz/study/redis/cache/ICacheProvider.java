package com.pazz.study.redis.cache;

/**
 * @author: 彭坚
 * @create: 2018/11/28 11:07
 * @description: mysql数据库提供者
 */
public interface ICacheProvider<V> {

    V get(String key);

}
