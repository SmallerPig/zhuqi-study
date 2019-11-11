package com.chinamobile.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zhuqi
 * @date create at 2019-10-16 9:24
 */
@SpringBootApplication
@EnableCaching
public class ShiroBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShiroBootApplication.class);
    }
}
