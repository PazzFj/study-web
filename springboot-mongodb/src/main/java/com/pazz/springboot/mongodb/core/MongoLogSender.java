package com.pazz.springboot.mongodb.core;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.pazz.springboot.mongodb.entity.LogInfo;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: 彭坚
 * @create: 2018/11/26 16:52
 * @description:
 */
public class MongoLogSender implements InitializingBean, DisposableBean {

    /**
     * 默认集合名称
     */
    public final static String DEFAULT_COLLECTION_NAME = LogInfo.class.getSimpleName();
    /**
     * 默认集合TTL失效索引名称
     */
    public final static String DEFAULT_COLLECTION_TTL_INDEX_NAME = "index_date_";
    /**
     * 默认TTL索引KEY
     */
    public final static String DEFAULT_COLLECTION_TTL_INDEX_KEY = "date";
    /**
     * 默认15天
     */
    public final static int DEFAULT_COLLECTION_TTL_INDEX_EXPIRE_SECONDS = 60 * 60 * 24 * 15;
    /**
     * TTL索引过期秒数
     * 默认15天
     */
    private int collectionTTLIndexExpireSeconds = DEFAULT_COLLECTION_TTL_INDEX_EXPIRE_SECONDS;
    /**
     * 集合名称
     */
    private String collectionName = DEFAULT_COLLECTION_NAME;
    /**
     * MongoTemplate
     */
    private MongoTemplate mongoTemplate;
    /**
     * 线程池
     */
    private ExecutorService threadPool = null;
    /**
     * 线程池大小
     */
    private int threadSize = 5;


    public MongoLogSender(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 批量发送日志
     */
    public void send(List<Object> msg) {

    }

    /**
     * 发送日志
     */
    public void send(Object msg) {

    }

    @Override
    public void destroy() throws Exception {
        threadPool.shutdown(); //关闭线程池
        while (!threadPool.isTerminated()) {  //线程池是否终止
            try {
                synchronized (this) {
                    this.wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        threadPool = new ThreadPoolExecutor(threadSize, threadSize, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5 * threadSize), new ThreadPoolExecutor.AbortPolicy());
    }

    private class SendTask implements Runnable {
        private List<Object> msg;

        public SendTask(List<Object> msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            List<DBObject> list = new Vector<>();
            for (Object obj : msg) {
                LogInfo log = (LogInfo) obj;
                list.add(getDBObject(log));
            }
            mongoTemplate.getCollection(collectionName).insertMany(list);
        }
    }

    public DBObject getDBObject(LogInfo logInfo) {
        DBObject obj = new BasicDBObject();
        Field[] fields = logInfo.getClass().getDeclaredFields();
        PropertyDescriptor pd = null;
        for (int i = 0; i < fields.length; i++) {
            try {
                pd = new PropertyDescriptor(fields[i].getName(), logInfo.getClass());
                Method m = pd.getReadMethod();
                obj.put(fields[i].getName(), m.invoke(logInfo));
            } catch (Exception e) {
                continue;
            }
        }
        return obj;
    }

}
