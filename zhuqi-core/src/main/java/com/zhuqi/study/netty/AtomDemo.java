package com.zhuqi.study.netty;

import java.util.Arrays;

/**
 * @author zhuqi at 2021/3/3
 */
public class AtomDemo {

    private static volatile long count = 0L;
    private static int NUMBER =10000;

    public static void main(String[] args) {

        SubtractTread subtractTread = new SubtractTread();
        subtractTread.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (AtomDemo.class){
                count++;

            }

        }
        while(subtractTread.isAlive()){}
        System.out.println("count = " + count);
    }

    private static class SubtractTread extends Thread{

        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (AtomDemo.class){
                    count--;
                }
//                count--;
            }
        }
    }
}
