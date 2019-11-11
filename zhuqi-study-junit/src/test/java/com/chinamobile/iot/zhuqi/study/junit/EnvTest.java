package com.chinamobile.iot.zhuqi.study.junit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.env.MockEnvironment;

import java.util.Map;

/**
 * @author zhuqi
 * @date create at 2019-10-22 13:49
 */
public class EnvTest {


    @Test
    public void test() {
        StandardEnvironment env = new StandardEnvironment();
        // 1. 操作系统的环境变量
        Map<String, Object> systemEnvironment = env.getSystemEnvironment();
        Assert.assertNotNull(systemEnvironment);

        // 2. JVM 属性配置
        Map<String, Object> systemProperties = env.getSystemProperties();
        Assert.assertNotNull(systemProperties);

        // 3. 属性
        Assert.assertEquals("UTF-8", env.getProperty("file.encoding"));
        Assert.assertTrue(env.containsProperty("file.encoding"));

        // 4. 剖面 spring.profiles.default(默认为 default) spring.profiles.active
        //    只要有一个返回 true acceptsProfiles 方法就返回 true，!a 为不包含该 profiles
        Assert.assertTrue(env.acceptsProfiles("default"));
        Assert.assertTrue(env.acceptsProfiles("a", "default"));
        Assert.assertFalse(env.acceptsProfiles("a"));
        Assert.assertTrue(env.acceptsProfiles("!a", "b"));
    }


    @Test
    public void mockEnvTest() {
        MockEnvironment mockEnvironment = new MockEnvironment();


    }
}
