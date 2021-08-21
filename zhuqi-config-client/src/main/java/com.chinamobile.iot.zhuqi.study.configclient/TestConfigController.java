package com.chinamobile.iot.zhuqi.study.configclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author zhuqi at 2018/7/20
 */
@RestController
@RefreshScope
public class TestConfigController {


    @Value("${info.file.name}")
    private String filename;

    @Value("${info.file.version}")
    private String version;


    @RequestMapping("/ping")
    public String ping() {
        return filename + version;
    }

}
