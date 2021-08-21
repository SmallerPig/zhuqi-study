package com.zhuqi.study.ht;

/**
 * @author zhuqi at 2021/2/8
 */
public class Test {


    public static void main(String[] args) {


        try {
            Test test = new Test();
            test.method1(1);
        } catch (Exception e) {
            System.out.println("method1 = " + e.getMessage());
        }
    }

    private void method1(int i){
        if(i == 0){
            return;
        }
        method1(++i);
    }
}
