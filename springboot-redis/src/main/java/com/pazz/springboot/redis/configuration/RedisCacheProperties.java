package com.pazz.springboot.redis.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.boot.cache")
public class RedisCacheProperties {
    /**
     * 过期时间
     */
    private int expireAfter = 60 * 10;

}
