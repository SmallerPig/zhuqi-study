package com.zhuqi.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi at 2020/9/18
 */
@SpringBootApplication
@RestController
public class BootApplication {


    @Autowired
    private UserDemoProperties userDemoProperties;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }




    @RequestMapping("/ping")
    public String ping(){
        String name = userDemoProperties.getName();
        return name;
    }

}
