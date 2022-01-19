package com.pazz.study.configuration;

import com.pazz.study.filter.TestFilter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 彭坚
 * @create: 2018/11/20 14:46
 * @description: 激活 Filter 装置
 */
@Configuration
@ConditionalOnWebApplication
@AutoConfigureBefore({TestConfiguration.class})
@ConditionalOnProperty(prefix = "framework.web.filter", name = "enabled", havingValue = "true")
public class WebMvcConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TestFilter testFilter() {
        return new TestFilter();
    }
}
