package zhuqi.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhuqi at 2018/11/16
 */
public class ListToArray {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>(3);

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Object[] array1 = list.toArray();
        System.out.println(Arrays.asList(array1));

        String[] array2 = new String[2];
        list.toArray(array2); //容量不够导致数组里面都是null
        System.out.println(Arrays.asList(array2));

        String[] array3 = new String[3];
        list.toArray(array3);
        System.out.print(Arrays.asList(array3));


    }
}
