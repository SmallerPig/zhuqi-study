package com.chinamobile.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhuqi
 * @date create at 2020-03-05 17:51
 */
@EnableEurekaServer
@EnableEurekaClient
@SpringBootApplication
public class EurekaBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaBootApplication.class);
    }

}
