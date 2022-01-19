package com.pazz.study.redis.redis.storage;

import com.pazz.study.redis.cache.ICache;
import com.pazz.study.redis.cache.exception.KeyIsNotFoundException;
import com.pazz.study.redis.cache.exception.ValueIsBlankException;
import com.pazz.study.redis.cache.exception.ValueIsNullException;
import com.pazz.study.redis.cache.CacheManager;
import com.pazz.study.redis.cache.ICacheProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/11/8 10:30
 * @description: 核心处理逻辑类
 */
public abstract class AbstractRedisCache<V> implements ICache<String, V>, InitializingBean, DisposableBean {

    /**
     * 日志
     */
    private final Log LOG = LogFactory.getLog(getClass());
    /**
     * 数据提供者(Data)
     */
    protected ICacheProvider<V> cacheProvider;
    /**
     * 数据储存器(RedisTemplate)
     */
    protected RedisCacheStorage<String, V> cacheStorage;
    /**
     * 超时时间,单位秒,默认10分钟
     */
    protected int timeOut = 0;

    public abstract String getUUID();

    /**
     * 设置数据提供者
     */
    public void setCacheProvider(ICacheProvider<V> cacheProvider) {
        this.cacheProvider = cacheProvider;
    }

    /**
     * 设置数据储存器
     */
    public void setCacheStorage(RedisCacheStorage<String, V> cacheStorage) {
        this.cacheStorage = cacheStorage;
    }

    /**
     * 设置超时时间
     */
    public void setTimeOut(int seconds) {
        this.timeOut = seconds;
    }

    /**
     * 根据uuid和key生成key
     */
    protected String getKey(String key) {
        return getUUID() + "_" + key;
    }

    /**
     * 获取缓存步骤：
     *      1、先从 RedisCacheStorage 中获取值
     *      2、如果 redis 缓存中返回为null 直接return null
     *      3、如果 redis 缓存中返回key为null 则从 mysql 数据库中获取 然后在保存到 redis 中
     *      4、如果 redis 连接失败 则从 mysql 数据库中获取
     *      5、如果 redis 其它异常, 直接 mysql 获取然后会犯
     */
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

    public Map<String, V> get() {
        throw new RuntimeException(getUUID() + ":TTLCache cannot get all!");
    }

    public void destroy() {
        CacheManager.getInstance().shutdown();
    }

    public void afterPropertiesSet() {
        CacheManager.getInstance().registerCacheProvider(this);
    }
}
