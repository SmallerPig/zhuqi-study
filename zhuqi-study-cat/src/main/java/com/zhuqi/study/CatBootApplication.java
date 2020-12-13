package com.zhuqi.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2020-04-17 11:46
 */
@SpringBootApplication
@RestController
public class CatBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatBootApplication.class);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }


}
