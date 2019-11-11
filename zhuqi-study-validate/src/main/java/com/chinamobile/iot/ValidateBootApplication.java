package com.chinamobile.iot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2019-11-08 16:12
 */
@SpringBootApplication
@RestController
@Validated
public class ValidateBootApplication {


    public static void main(String[] args) {
        SpringApplication.run(ValidateBootApplication.class);
    }


}
