package com.chinamobile.iot.zhuqi.study.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2019-10-17 9:42
 */
@SpringBootApplication
@RestController
public class H2BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(H2BootApplication.class);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

}
