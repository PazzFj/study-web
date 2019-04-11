package com.pazz.springboot.redis.example.cache.redis;

import com.pazz.springboot.redis.example.cache.exception.CacheRedisException;
import com.pazz.springboot.redis.example.cache.exception.KeyIsNotFoundException;
import com.pazz.springboot.redis.example.cache.exception.ValueIsNullException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:13
 * @description:
 */
public class RedisCacheStorage<K, V> implements ICacheStorage<K, V> {

    private final Log log = LogFactory.getLog(getClass());

    private RedisTemplate redisTemplate;

    private int expire = 60 * 10;

    public V get(K key) {
        if(key == null){
            throw new CacheRedisException("key does not allow for null!");
        }
        boolean exist =  redisTemplate.hasKey(key);
        if(!exist){
            throw new KeyIsNotFoundException("key is not found!");
        }
        Object value = redisTemplate.opsForValue().get(key);
        if(value == null){
            throw new ValueIsNullException("key exists, value is null!");
        }
        return (V) value;
    }

    public boolean set(K key, V value) {
        set(key, value, expire);
        return true;
    }

    public boolean set(K key, V value, int exp) {
        if(key == null){
            throw new CacheRedisException("key does not allow for null!");
        }
        log.info("key: " + key + "   value: " + value + "  expire: " + exp);
        redisTemplate.opsForValue().set(key, value, exp, TimeUnit.SECONDS);
        return true;
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
