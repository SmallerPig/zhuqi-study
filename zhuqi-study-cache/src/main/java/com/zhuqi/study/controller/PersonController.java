package com.zhuqi.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuqi
 * @date create at 2019-10-17 19:21
 */
@RestController
public class PersonController {

    private static final String CACHE_NAME = "ping";

    /**
     * LOGGER 对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping("/ping/{id}")
    @Cacheable(value = CACHE_NAME, keyGenerator = "cacheKeyGenerator")
    public String ping(@PathVariable Long id) {
        LOG.info("ping begin,{}", id);
        return "pong";
    }

    @RequestMapping("/remove/{id}")
    @CacheEvict(value = CACHE_NAME, keyGenerator = "cacheKeyGenerator")
    public String remove(@PathVariable Long id) {
        LOG.info("ping remove,{}", id);
        return "pong";

    }

}
