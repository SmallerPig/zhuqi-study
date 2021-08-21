package com.zhuqi.quartz;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author zhuqi at 2020/9/18
 */
@ConfigurationProperties(prefix = "demo.value")
@Component
public class UserDemoProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
