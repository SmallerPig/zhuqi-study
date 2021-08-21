package com.zhuqi.study.zhuqi.study.apollo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuqi at 2020/8/29
 */
@Configuration
@ConfigurationProperties(prefix = "ping")
public class ApolloDemoProperties {
    private String value;

    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApolloDemoProperties{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
