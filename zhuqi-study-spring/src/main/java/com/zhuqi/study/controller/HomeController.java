package com.zhuqi.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2019-11-01 16:36
 */
@RestController
public class HomeController {

    /**
     * LOGGER 对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    private Long id;


    @RequestMapping("/ping/{id}")
    public Long ping(@PathVariable("id") Long id) throws InterruptedException {
        this.id = id;
        Thread.sleep(1);
        LOG.info("id:{},      this.id:{}", id, this.id);
        return this.id;
    }


}
