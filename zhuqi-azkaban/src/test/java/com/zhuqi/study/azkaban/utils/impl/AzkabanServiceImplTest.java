package com.zhuqi.study.azkaban.utils.impl;

import org.junit.Test;

/**
 * @author zhuqi at 2021/9/5
 */
public class AzkabanServiceImplTest {
    AzkabanServiceImpl azkabanService = new AzkabanServiceImpl();

    @Test
    public void login() throws Exception {
        String login = azkabanService.login();
        System.out.println("login = " + login);
    }

    /**
     * 测试:创建一个项目
     */
    @Test
    public void testCreateProject() throws Exception {
        azkabanService.createProject("zhuqi-demo-project","project description");

    }
}
