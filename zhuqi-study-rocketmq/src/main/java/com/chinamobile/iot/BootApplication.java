package com.chinamobile.iot;

import com.chinamobile.iot.mq.UpdateNameProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuqi
 * @date create at 2019-10-14 14:48
 */
@SpringBootApplication
public class BootApplication {

    private final UpdateNameProducer updateNameProducer;

    @Autowired(required = false)
    public BootApplication(UpdateNameProducer updateNameProducer) {
        this.updateNameProducer = updateNameProducer;
    }


    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class);
    }
}
