package zhuqi.study.study.stater.use;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zhuqi at 2020/8/28
 */

public class BootTest {

    @org.junit.Test
    public void hello() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Boot.class);
        Object demoService = ctx.getBean("demoService");
        System.out.println("demoService = " + demoService);


    }

}