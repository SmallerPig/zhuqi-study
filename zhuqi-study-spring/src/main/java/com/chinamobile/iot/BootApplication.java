package com.chinamobile.iot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi
 * @date create at 2019-10-11 14:07
 */
@SpringBootApplication
public class BootApplication {

    /**
     * LOGGER 对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(BootApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        MockEnvironment mockEnvironment = new MockEnvironment();
//        context.register(Appconfig.class);
//        context.setEnvironment(mockEnvironment);
//        context.refresh();
//
//        IndexService indexService = context.getBean(IndexService.class);


    }
}
