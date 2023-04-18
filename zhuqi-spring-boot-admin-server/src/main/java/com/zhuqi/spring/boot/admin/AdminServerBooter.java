package com.zhuqi.spring.boot.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi at 2021/10/11
 */
@SpringBootApplication
@EnableAdminServer
public class AdminServerBooter {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerBooter.class);
    }
}
