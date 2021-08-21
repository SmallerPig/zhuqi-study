package zhuqi.study.spring;

import zhuqi.study.Cat;

/**
 * @author zhuqi at 2020/8/2
 */
public class Boot {

    public static void main(String[] args) {
        Cat cat = (Cat)BeanFactory.getBean("cat");
        System.out.println("cat = " + cat);
    }
}
