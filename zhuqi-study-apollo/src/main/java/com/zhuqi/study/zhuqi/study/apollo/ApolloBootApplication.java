package com.zhuqi.study.zhuqi.study.apollo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi at 2020/8/29
 */
@SpringBootApplication
@RestController
public class ApolloBootApplication {

    @Value("${ping.value:defaultValue}")
    private String pingValue;

    @Autowired
    private ApolloDemoProperties apolloDemoProperties;

    public static void main(String[] args) {
        SpringApplication.run(ApolloBootApplication.class);
    }


    @RequestMapping("/ping")
    public String ping(){
        return pingValue;
    }

    @RequestMapping("/ping1")
    public String ping1(){
        return apolloDemoProperties.toString();
    }


}
