package com.chinamobile.iot.zhuqi.study.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhuqi at 2018/7/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBootApplication.class, args);
    }

}
