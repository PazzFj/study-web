package com.pazz.springboot.mongodb.core;

import com.pazz.springboot.mongodb.entity.LogInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.Document;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
@Component
public class MongoLogSender implements InitializingBean, DisposableBean {

    public static final Log log = LogFactory.getLog(MongoLogSender.class);
    /**
     * 集合名称
     */
    private String collectionName = DEFAULT_COLLECTION_NAME;
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
     * 请求ID索引KEY
     */
    private String collectionRequestIdIndexKey = "requestId";
    /**
     * 请求ID索引名称
     */
    private String collectionRequestIdIndexName = "index_requestId_";
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
     * TTL索引name
     */
    private String collectionTTLIndexName = DEFAULT_COLLECTION_TTL_INDEX_NAME;
    /**
     * TTL索引key
     */
    private String collectionTTLIndexKey = DEFAULT_COLLECTION_TTL_INDEX_KEY;
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

    /**
     * 初始化(构造器)
     */
    public MongoLogSender(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * 批量发送日志
     */
    public void send(List<Object> msg) {
        threadPool.submit(new SendTask(msg));
    }

    /**
     * 发送日志
     */
    public void send(Object msg) {
        List<Object> lists = new ArrayList<>();
        lists.add(msg);
        threadPool.submit(new SendTask(lists));
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

    /**
     * after
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        //创建索引
        createIndex();
        threadPool = new ThreadPoolExecutor(threadSize, threadSize, 3, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5 * threadSize), new ThreadPoolExecutor.AbortPolicy());
    }

    /**
     * 创建索引
     */
    private void createIndex() {
        try {
            List<IndexInfo> infoList = mongoTemplate.indexOps(collectionName).getIndexInfo();
            if (!existIndex(infoList, collectionTTLIndexName)) {
                //创建TTL索引
                mongoTemplate.indexOps(collectionName).ensureIndex(new Index().named(collectionTTLIndexName).on(collectionTTLIndexKey, Sort.Direction.DESC).expire(collectionTTLIndexExpireSeconds));
            }
            if (!existIndex(infoList, collectionRequestIdIndexName)) {
                //创建requestId索引
                mongoTemplate.indexOps(collectionName).ensureIndex(new Index(collectionRequestIdIndexKey, Sort.Direction.ASC).named(collectionRequestIdIndexName));
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private boolean existIndex(List<IndexInfo> infoList, String collectionName) {
        return infoList.stream().anyMatch(indexInfo -> isEquals(collectionName, indexInfo.getName()));
    }

    public static boolean isEquals(String str1, String str2) {
        if (str1 == null) {
            return str2 == null;
        }
        return str1.equals(str2);
    }

    private class SendTask implements Runnable {
        private List<Object> msg;

        public SendTask(List<Object> msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            List<Document> list = new Vector<>();
            for (Object obj : msg) {
                LogInfo log = (LogInfo) obj;
                list.add(getDocument(log));
            }
            mongoTemplate.getCollection(collectionName).insertMany(list);
        }
    }

    public static Document getDocument(Object object) {
        Document obj = new Document();
        Field[] fields = object.getClass().getDeclaredFields();
        PropertyDescriptor pd = null;
        for (int i = 0; i < fields.length; i++) {
            try {
                pd = new PropertyDescriptor(fields[i].getName(), object.getClass());
                Method m = pd.getReadMethod();
                obj.put(fields[i].getName(), m.invoke(object));
            } catch (Exception e) {
                continue;
            }
        }
        return obj;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public int getThreadSize() {
        return threadSize;
    }

    public void setThreadSize(int threadSize) {
        this.threadSize = threadSize;
    }

    public String getCollectionTTLIndexName() {
        return collectionTTLIndexName;
    }

    public void setCollectionTTLIndexName(String collectionTTLIndexName) {
        this.collectionTTLIndexName = collectionTTLIndexName;
    }

    public int getCollectionTTLIndexExpireSeconds() {
        return collectionTTLIndexExpireSeconds;
    }

    public void setCollectionTTLIndexExpireSeconds(int collectionTTLIndexExpireSeconds) {
        this.collectionTTLIndexExpireSeconds = collectionTTLIndexExpireSeconds;
    }
}
