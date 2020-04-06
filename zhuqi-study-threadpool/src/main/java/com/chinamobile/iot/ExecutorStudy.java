package com.chinamobile.iot;

import java.util.concurrent.*;

/**
 * @author zhuqi
 * @date create at 2020-03-27 14:36
 */
public class ExecutorStudy {
    private static ExecutorService executor1 = Executors.newFixedThreadPool(15);
    private static ExecutorService executor2 = new ThreadPoolExecutor(10, 10,
            60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));

    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            final int in = i;
            executor1.execute(() -> {
                try {
                    System.out.println(in);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //do nothing
                }
            });
        }
    }


}
