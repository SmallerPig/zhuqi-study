package com.zhuqi.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2020-02-16 22:37
 */

@SpringBootApplication
@RestController
public class BootApplication {


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }


}
