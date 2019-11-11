package com.chinamobile.iot.zhuqi.study.thread;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author zhuqi
 * @date create at 2019-10-25 9:58
 */
public class ScheduledThreadPoolDemo {


    public static void main(String[] args) {
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
//
//        executor.scheduleAtFixedRate(() -> {
//            long start = new Date().getTime();
//            System.out.println("scheduleAtFixedRate 开始执行时间:" +
//                    DateFormat.getTimeInstance().format(new Date()));
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            long end = new Date().getTime();
//            System.out.println("scheduleAtFixedRate 执行花费时间=" + (end - start) / 1000 + "m");
//            System.out.println("scheduleAtFixedRate 执行完成时间：" + DateFormat.getTimeInstance().format(new Date()));
//            System.out.println("======================================");
//        }, 1, 5, TimeUnit.SECONDS);
//

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNamePrefix("demo-pool-zhuqi")
                .build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(() -> {
                    long start = new Date().getTime();
                    System.out.println("scheduleAtFixedRate 开始执行时间:" +
                            DateFormat.getTimeInstance().format(new Date()));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    long end = new Date().getTime();
                    System.out.println("");
                    System.out.println("scheduleAtFixedRate 执行花费时间=" + (end - start) / 1000 + "m");
                    System.out.println("scheduleAtFixedRate 执行完成时间：" + DateFormat.getTimeInstance().format(new Date()));
                    System.out.println("======================================");
                }

        );
        pool.shutdown();//gracefully shutdown


    }
}
