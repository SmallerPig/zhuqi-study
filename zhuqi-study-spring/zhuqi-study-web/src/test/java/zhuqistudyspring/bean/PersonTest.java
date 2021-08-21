package zhuqistudyspring.bean;

import zhuqistudyspring.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zhuqi at 2020/8/9
 */
public class PersonTest {


    @Test
    public void test1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * xml加载配置文件
     */
    @Test
    public void test2(){
        ApplicationContext ctx =  new ClassPathXmlApplicationContext("/applicationContext.xml");
        Object person = ctx.getBean("person");
        System.out.println("person = " + person);
        assertTrue(person instanceof Person);
    }

    /**
     * 测试:jingdong 京东京造的蓝牙无线机械键盘
     */
    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Object person = ctx.getBean("person");
        System.out.println("person = " + person);
        assertTrue(person instanceof Person);
    }

    /**
     * 测试:aop
     */
    @Test
    public void test4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("zhuqi", "123456");
    }

}
