package com.zhuqi.study;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi
 * @date create at 2020-01-22 16:37
 */
@SpringBootApplication
@EnableDubbo
public class DubboServiceBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServiceBootApplication.class);
    }

}
