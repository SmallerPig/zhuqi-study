package com.zhuqi.spring.boot.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi at 2021/10/11
 * 启动本服务之前,先确认server端是否已经启动成功
 */
@SpringBootApplication
public class AdminClientBooter {

    public static void main(String[] args) {
        SpringApplication.run(AdminClientBooter.class);
    }
}
