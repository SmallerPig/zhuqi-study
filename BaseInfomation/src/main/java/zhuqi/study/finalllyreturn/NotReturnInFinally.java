package zhuqi.study.finalllyreturn;

/**
 * @author zhuqi at 2018/12/3
 */
public class NotReturnInFinally {

    public static void main(String[] args) {
        int i = 1;
        int j = 0;


        try {
            System.out.println("try -");
            divide(i, j);
        } catch (Exception e) {
            System.out.println("catch-----");
        } finally {
            System.out.println("finally-------");
        }
    }

    static int divide(int i, int j) {
        try {
            System.out.println("divide try -------");
            int r = i / j;
        } catch (Exception e) {
            System.out.println("divide catch --------");
            throw e;
        } finally {
            System.out.println("divide  finally---------");
            return 0;
        }


    }

}
