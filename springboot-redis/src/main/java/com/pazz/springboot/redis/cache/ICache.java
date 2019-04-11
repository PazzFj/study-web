package com.pazz.springboot.redis.cache;

import java.util.Map;

public interface ICache<K, V> extends ICacheId {

    V get(K key);

    Map<K, V> get();
}
