package com.pazz.study.redis.example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: 彭坚
 * @create: 2019/4/11 17:34
 * @description:
 */
@Data
@ConfigurationProperties(prefix = "framework.cache")
public class CacheProperties {

    /**
     * 过期时间
     */
    private int expireAfter = 60 * 10;

}
