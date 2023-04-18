package com.zhuqi.study.thread.local;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhuqi at 2021/10/11
 */
@SpringBootTest
@SpringBootConfiguration
class ThreadUserLocalTest {


    /**
     * 测试:用来测试thread是否正常工作
     */
    @Test
    @DisplayName("用来测试thread是否正常工作")
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("zhuqi");
        ThreadUserLocal.set(userInfo);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                ThreadUserLocal.set(new UserInfo());
                System.out.println("ThreadUserLocal.get().hashCode() = " + ThreadUserLocal.get().hashCode());
            }
        }, "线程1");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                ThreadUserLocal.set(new UserInfo());

                System.out.println("ThreadUserLocal.get().hashCode() = " + ThreadUserLocal.get().hashCode());
            }
        }, "线程2");


        t1.run();
        t2.run();
    }
}
