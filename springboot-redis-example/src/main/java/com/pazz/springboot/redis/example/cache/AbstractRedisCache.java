package com.pazz.springboot.redis.example.cache;

import com.pazz.springboot.redis.example.cache.exception.KeyIsNotFoundException;
import com.pazz.springboot.redis.example.cache.exception.ValueIsBlankException;
import com.pazz.springboot.redis.example.cache.exception.ValueIsNullException;
import com.pazz.springboot.redis.example.cache.mysql.ICacheProvider;
import com.pazz.springboot.redis.example.cache.redis.RedisCacheStorage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:50
 * @description:
 */
@Component
public abstract class AbstractRedisCache<V> implements ICache<String, V>, InitializingBean {

    private final Log LOG = LogFactory.getLog(getClass());

    protected int timeOut = 0;

    private ICacheProvider<V> cacheProvider;

    private RedisCacheStorage<String, V> redisCacheStorage;

    protected String getKey(String key) {
        return getUUID() + "_" + key;
    }

    public V get(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("key does not allow for null!");
        }
        V value = null;
        try {
            value = redisCacheStorage.get(getKey(key));
        } catch (ValueIsBlankException e) { //value 为空串
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]存在，value为空串，返回结果[null]");
            return null;
        } catch (ValueIsNullException e) {  //value 为null
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]存在，value为null，返回结果[null]");
            return null;
        } catch (KeyIsNotFoundException e) {  //key 不存在
            value = cacheProvider.get(key);
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]不存在，走数据库查询，返回结果[" + value + "]");
            if(timeOut > 0){
                redisCacheStorage.set(getKey(key), value, timeOut);
            }else {
                redisCacheStorage.set(getKey(key), value);
            }
        } catch (RedisConnectionFailureException e) {
            value = cacheProvider.get(key);
            LOG.warn("redis连接出现异常，走数据库查询!");
            return value;
        } catch (Exception e) {
            //其他异常
            e.printStackTrace();
            value = cacheProvider.get(key);
        }
        return value;
    }

    public Map<String, V> get() {
        throw new RuntimeException(getUUID() + ":TTLCache cannot get all!");
    }

    public void setCacheProvider(ICacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    public void setRedisCacheStorage(RedisCacheStorage<String, V> redisCacheStorage) {
        this.redisCacheStorage = redisCacheStorage;
    }

    public void afterPropertiesSet() throws Exception {
        CacheManage.getInstance().registerCacheProvider(this);
    }
}
