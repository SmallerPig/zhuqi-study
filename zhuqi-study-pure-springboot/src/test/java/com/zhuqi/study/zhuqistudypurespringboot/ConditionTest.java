package com.zhuqi.study.zhuqistudypurespringboot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuqi at 2020/9/2
 */
@ActiveProfiles(value = "test")
@SpringBootTest(classes = ZhuqiStudyPureSpringbootApplication.class)
@DisplayName("测试方法名")
public class ConditionTest {


    /**
     * 测试:是否加载配置类
     */
    @Test
    @DisplayName("这是测试方法1")
    public void test1(){
        System.out.println("hello world");
    }

    /**
     * 测试:测试方法2
     */
    @Test
    @DisplayName("在是测试方法2")
    public void test2(){
        System.out.println("hello2");
    }


    /**
     * 测试: 测试超时
     */
    @DisplayName("测试超时时间是否正常")
    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void test4() throws InterruptedException {
        Thread.sleep(600);
    }

    /**
     * 测试:重复测试
     */
    @Test
    @RepeatedTest(5)
    public void test5(){
        System.out.println("repeat times");
    }

}
