package com.zhuqi.study;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.zhuqi.study.service.TestFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2020-04-23 16:40
 */
@SpringBootApplication
@EnableFeignClients
@RestController
@EnableApolloConfig
public class FeignBootApplication {

    @Autowired
    private TestFeignService testFeignService;

    public static void main(String[] args) {
        SpringApplication.run(FeignBootApplication.class);
    }


    @RequestMapping("/ping")
    public String ping() {
        return testFeignService.getIndex();
    }


}
