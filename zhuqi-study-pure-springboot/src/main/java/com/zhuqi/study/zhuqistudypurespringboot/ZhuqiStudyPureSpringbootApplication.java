package com.zhuqi.study.zhuqistudypurespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author smallerpig
 */
@SpringBootApplication
public class ZhuqiStudyPureSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZhuqiStudyPureSpringbootApplication.class, args);
        System.out.println(context.getId());
        System.out.println(context.getBean("user"));

        System.out.println("hello world");

    }
}
