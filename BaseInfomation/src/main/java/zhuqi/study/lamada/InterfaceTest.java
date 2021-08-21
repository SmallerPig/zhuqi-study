package zhuqi.study.lamada;

/**
 * @author zhuqi at 2018/12/5
 */
public class InterfaceTest {

    public static void main(String[] args) {

        IDoSomething doSomething = () -> System.out.println("hello");

        useDoSome(doSomething);

        useDoSome(() -> System.out.println("doSome"));

        useDoSome(new IDoSomething() {
            @Override
            public void doSome() {
                System.out.println("doSome by new IDoSomething");
            }
        });
    }


    static void useDoSome(IDoSomething doSomething) {
        doSomething.doSome();
    }

    public interface IDoSomething {
        void doSome();

    }
}
