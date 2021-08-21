package zhuqi.study.lamada;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * @author zhuqi at 2018/12/5
 */
public class BaseShow {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");

        ActionListener actionListener = event -> System.out.println("button click");

        Runnable runnable1 = () -> {
            System.out.println("111");
            System.out.println("222");
        };

        BinaryOperator<Long> add = (x, y) -> x + y;

        BinaryOperator<Long> add1 = (Long x, Long y) -> x + y;


    }
}
