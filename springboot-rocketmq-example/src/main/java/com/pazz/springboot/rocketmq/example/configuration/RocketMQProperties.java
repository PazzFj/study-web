package com.pazz.springboot.rocketmq.example.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: 彭坚
 * @create: 2019/5/16 11:28
 * @description: RocketMQ配置文件
 */
@Data
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMQProperties {
    /**
     * 服务地址
     */
    private String nameServerAddress;
    /**
     * 生产组名称
     */
    private String producerGroup;
    /**
     * VIP 通道是否启用
     */
    private boolean vipChannelEnable = false;
    /**
     * 消费者是否可用
     */
    private boolean consumerEnable = true;

}
