package com.zhuqi.study.netty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuqi at 2021/3/1
 */
public class MainStart {

    public static void main(String[] args) {
        MainStart start = new MainStart();
        System.out.println("start.hashCode() = " + start.hashCode());

        List<Integer> lists = new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        System.out.println("lists.subList(0,1) = " + lists.subList(0, 2));




    }
}
