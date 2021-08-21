package com.zhuqi.study.netty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqi at 2020/12/9
 */
public class Acc {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        add(list);
        for (Integer j : list) {
            System.err.print(j+",");;
        }
        System.err.println("");
        System.err.println("*********************");
        String a="A";
        append(a);
        System.err.println(a);
        int num = 5;
        addNum(num);
        System.err.println(num);
    }

    static void add(final List<Integer> list){
        list.add(100);
    }

    static void append(String str){
        str+="is a";
    }
    static void addNum(int a){
        a=a+10;
    }
}
