package com.zhuqi.study.zhuqi.study.logback;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhuqi at 2020/8/20
 */
public class LogbackTest {

    /**
     * 测试:
     */
    @org.junit.Test
    public void test1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestAppConfig.class);
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
