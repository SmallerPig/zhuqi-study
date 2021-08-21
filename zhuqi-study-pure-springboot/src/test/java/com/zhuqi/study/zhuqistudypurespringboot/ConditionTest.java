package com.zhuqi.study.zhuqistudypurespringboot;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author zhuqi at 2020/9/2
 */
@ActiveProfiles(value = "test")
@SpringBootTest(classes = ZhuqiStudyPureSpringbootApplication.class)
public class ConditionTest {


    /**
     * 测试:是否加载配置类
     */
    @Test
    public void test1(){

    }
}
