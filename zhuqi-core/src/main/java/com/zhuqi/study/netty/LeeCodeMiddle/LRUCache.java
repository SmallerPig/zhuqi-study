package com.zhuqi.study.netty.LeeCodeMiddle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuqi at 2021/3/12
 */
class LRUCache {
    private int capacity;
    private Map<Integer, Integer> maps = new ConcurrentHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        String s = "hello world";
    }

    public int get(int key) {
        // 给使用次数+1;
        return maps.get(key);
    }

    public void put(int key, int value) {
        if(maps.size()>=capacity){

        }
        maps.put(key, value);

    }
}
