package com.pazz.springboot.redis.common;

import com.pazz.springboot.redis.cache.ICache;
import com.pazz.springboot.redis.cache.ICacheProvider;
import com.pazz.springboot.redis.cache.exception.KeyIsNotFoundException;
import com.pazz.springboot.redis.cache.exception.ValueIsBlankException;
import com.pazz.springboot.redis.cache.exception.ValueIsNullException;
import com.pazz.springboot.redis.redis.storage.RedisCacheStorage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author: 彭坚
 * @create: 2019/4/4 17:26
 * @description:
 */
public abstract class AbstractTestARedisCache<V> implements ICache<String, V>, InitializingBean {

    private static final Log LOG = LogFactory.getLog(AbstractTestARedisCache.class);

    protected int timeOut = 0;

    private ICacheProvider<V> cacheProvider;

    private RedisCacheStorage<String, V> cacheStorage;

    public void setCacheProvider(ICacheProvider cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    public void setCacheStorage(RedisCacheStorage cacheStorage) {
        this.cacheStorage = cacheStorage;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public V get(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new RuntimeException("key does not allow for null!");
        }
        V value = null;
        try {
            value = cacheStorage.get(getKey(key));
        } catch (ValueIsBlankException e) {
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]存在，value为空串，返回结果[null]");
            //key存在，value为空串
            return null;
        } catch (ValueIsNullException ex) {
            //key存在，value为null
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]存在，value为null，返回结果[null]");
            return null;
        } catch (KeyIsNotFoundException ex1) {
            //key不存在
            value = cacheProvider.get(key);
            LOG.warn("缓存[" + getUUID() + "]，key[" + key + "]不存在，走数据库查询，返回结果[" + value + "]");
            if (timeOut > 0) {
                cacheStorage.set(getKey(key), value, timeOut);
            } else {
                cacheStorage.set(getKey(key), value);
            }
        } catch (RedisConnectionFailureException exx) {
            //redis 连接出现异常
            value = cacheProvider.get(key);
            LOG.warn("redis连接出现异常，走数据库查询!");
            return value;
        } catch (Exception e) {
            //其他异常
            e.printStackTrace();
            value = cacheProvider.get(key);
            return value;
        }
        return value;
    }

    /**
     * 根据uuid和key生成key
     */
    protected String getKey(String key) {
        return getUUID() + "_" + key;
    }

    public Map<String, V> get() {
        return null;
    }

    public void invalid() {

    }

    public void invalid(String key) {

    }

    public void invalidMulti(String... keys) {

    }

    public String getUUID() {
        return null;
    }

    public void afterPropertiesSet() throws Exception {
        CacheManage.getInstance().registerCacheProvider(this);
    }
}
