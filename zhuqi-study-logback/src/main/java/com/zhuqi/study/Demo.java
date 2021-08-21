package com.zhuqi.study;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqi at 2020/9/15
 */
public class Demo {

    static ExecutorService executorService;

    public static void main(String[] args) {
        try {


            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService = executorService;


            int size = 99;
            CountDownLatch latch = new CountDownLatch(size);

            for (int a = 0; a < size; a++) {
                int finalA = a;
                executorService.execute(new Runner(latch));
            }
            System.out.println("主线程继续执行latch.await()之前。。。。。。。。。。。。。。");

            latch.await();
            System.out.println("主线程继续执行latch.await()之后,这句话应该不管size是多少,永远在最后。。。");
            executorService.shutdown();

        } catch (Exception e) {
            executorService.shutdownNow();
            e.printStackTrace();
        }
    }
}

class Runner implements Runnable{

    CountDownLatch latch;

    public Runner(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("线程"+Thread.currentThread().getName()+"正在执行");
        latch.countDown();
    }
}
