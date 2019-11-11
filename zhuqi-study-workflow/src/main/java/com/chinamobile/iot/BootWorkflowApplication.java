package com.chinamobile.iot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhuqi at 2019/3/12
 */
@SpringBootApplication
@RestController
public class BootWorkflowApplication {


    /**
     * LOGGER 对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(BootWorkflowApplication.class);


    public static void main(String[] args){
        SpringApplication.run(BootWorkflowApplication.class);

        LOG.info("spring boot application start success!");

    }




}
