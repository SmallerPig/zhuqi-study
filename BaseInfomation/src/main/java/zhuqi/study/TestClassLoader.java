package zhuqi.study;

/**
 * @author zhuqi at 2018/11/30
 */
public class TestClassLoader {


    public static void main(String[] args) {

        ClassLoader c = TestClassLoader.class.getClassLoader();
        System.out.println(c);
        ClassLoader c1 = c.getParent();

        System.out.println(c1);
        ClassLoader c2 = c1.getParent();
        System.out.println(c2);

    }


}
