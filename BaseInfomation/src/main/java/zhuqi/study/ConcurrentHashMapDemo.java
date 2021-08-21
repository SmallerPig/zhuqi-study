package zhuqi.study;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhuqi at 2018/11/19
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {


        ConcurrentHashMap maps = new ConcurrentHashMap();
        maps.put("name", "smallerpig");
        maps.put("age", "11");
        maps.put("sex", "male");


        System.out.println(maps.containsKey("name"));
        System.out.println(maps.contains("name"));
    }
}
