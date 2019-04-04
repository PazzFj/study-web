package com.pazz.springboot.redis.redis.storage;

import com.pazz.springboot.redis.cache.IRemoteCacheStorage;
import com.pazz.springboot.redis.redis.exception.CacheRedisException;
import com.pazz.springboot.redis.cache.exception.KeyIsNotFoundException;
import com.pazz.springboot.redis.cache.exception.ValueIsNullException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: Peng Jian
 * @create: 2018/11/8 10:41
 * @description: redis存储
 */
public class RedisCacheStorage<K, V> implements IRemoteCacheStorage<K, V> {

    private final Log log = LogFactory.getLog(getClass());
    private RedisTemplate redisTemplate;
    private int expire = 60 * 10;

    public RedisCacheStorage() {
    }

    public boolean set(K key, V value) {
        set(key, value, expire);
        return true;
    }

    public boolean set(K key, V value, int exp) {
        if (key == null) {
            throw new CacheRedisException("key does not allow for null!");
        }
        log.info("key: " + key + "   value: " + value + "  expire: " + exp);
        redisTemplate.opsForValue().set(key, value, exp, TimeUnit.SECONDS);
        return true;
    }

    public V get(K key) {
        if (key == null) {
            throw new CacheRedisException("key does not allow for null!");
        }
        boolean exist = redisTemplate.hasKey(key);
        if (!exist) {
            throw new KeyIsNotFoundException("key is not found!");
        }
        log.info("key: " + key);
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj == null) {
            throw new ValueIsNullException("key exists, value is null!");
        }
        return (V) obj;
    }

    public void remove(K key) {
        redisTemplate.delete(key);
    }

    public void removeMulti(K... keys) {
        redisTemplate.delete(keys);
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

}
