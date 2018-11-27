package com.pazz.springboot.redis.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.boot.cache")
public class CacheProperties {
    /**
     * 过期时间
     */
    private int expireAfter = 60 * 10;

}
