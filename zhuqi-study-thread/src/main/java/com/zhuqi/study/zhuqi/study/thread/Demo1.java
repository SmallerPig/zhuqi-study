package com.zhuqi.study.zhuqi.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqi
 * @date create at 2019-10-25 9:47
 */
public class Demo1 {

    public static void main(String[] args) throws Exception {
        new Thread() {
            @Override
            public void run() {
                System.out.println("hello world");
                // 业务逻辑
            }
        }.start();


        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {

            final int index = i;

            Thread.sleep(1000);

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + index);
                }
            });
        }

    }
}
