package com.zhuqi.study.zhuqi.study.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuqi
 * @date create at 2019-10-17 9:42
 */
//@SpringBootApplication
//@RestController
public class H2BootApplication {


    public static void main(String[] args) {
        Integer s = null;
        if (0 == s) {
            System.out.println("1111");
        }


        SpringApplication.run(H2BootApplication.class);
    }

    @RequestMapping("/ping")
    public String ping() {
        return "pong";
    }

}
