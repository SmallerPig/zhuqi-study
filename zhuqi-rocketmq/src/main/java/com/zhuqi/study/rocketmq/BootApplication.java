package com.zhuqi.study.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi at 2020/9/15
 */
@SpringBootApplication
public class BootApplication {


    // 注入rocketMQ的模板
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }
}
