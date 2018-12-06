package com.pazz.springboot.redis.cache;

/**
 * @author: 彭坚
 * @create: 2018/11/28 11:07
 * @description: 缓存数据提供者
 */
public interface ICacheProvider<V> {

    /**
     * @description: 加载单个元素
     */
    V get(String key);

}
