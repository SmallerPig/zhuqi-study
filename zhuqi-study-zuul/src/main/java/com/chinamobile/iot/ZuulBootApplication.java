package com.chinamobile.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhuqi
 * @date create at 2019-11-15 14:27
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(ZuulBootApplication.class);
    }
}
