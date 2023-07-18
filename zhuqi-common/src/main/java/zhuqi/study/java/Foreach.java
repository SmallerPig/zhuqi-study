package zhuqi.study.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author zhuqi at 2023/7/18
 */
public class Foreach {


    /**
     * foreach demo
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("========= List 的 foreach 使用 =========");

        List<String> names = Arrays.asList("Alax", "Brian", "Charles");
        names.forEach(i -> System.out.println("i = " + i));
        names.forEach(System.out::println);


        Consumer<String> makerUp = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toLowerCase());
            }
        };
        names.forEach(makerUp);

        System.out.println("========= Map 的 foreach 使用 =========");

        Map<String, String> maps = new HashMap<>();
        maps.put("A", "Alax");
        maps.put("B", "Brian");
        maps.put("C", "Charles");

        maps.forEach((k, v) -> {
            System.out.println("k = " + k + ", v =" + v);
        });
        System.out.println();


        BiConsumer<String, String> action = new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("Key is = " + s);
                System.out.println("Value is = " + s2);
            }
        };

        maps.forEach(action);


    }
}
