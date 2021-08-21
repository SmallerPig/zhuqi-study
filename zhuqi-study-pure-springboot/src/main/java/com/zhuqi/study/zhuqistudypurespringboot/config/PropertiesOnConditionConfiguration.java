package com.zhuqi.study.zhuqistudypurespringboot.config;

import com.zhuqi.study.zhuqistudypurespringboot.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhuqi at 2020/9/2
 */
@Configuration
@ConditionalOnProperty(value = "zhuqi.study.condition", havingValue = "true")
public class PropertiesOnConditionConfiguration {

    @Bean
    public User user(){
        User user = new User();
        user.setName("zhuqi");
        return user;
    }

}
