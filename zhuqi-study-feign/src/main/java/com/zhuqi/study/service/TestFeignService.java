package com.zhuqi.study.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhuqi
 * @date create at 2020-04-23 16:42
 */
@FeignClient(url = "${feign.demo.url}", name = "baidu", value = "baidu")
public interface TestFeignService {

    @GetMapping("/")
    String getIndex();
}
