package com.zhuqi.study;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2020-03-05 16:43
 */
@SpringBootApplication
@RestController
public class ApolloBootApplication {

    @Value("${app.info}")
    private String appInfo;


    @Value("${app.version}")
    private String appVersion;


    public static void main(String[] args) {
        SpringApplication.run(ApolloBootApplication.class);
    }

    @RequestMapping("/ping")
    public String ping() {
        return appInfo + ":" + appVersion;
    }


}

