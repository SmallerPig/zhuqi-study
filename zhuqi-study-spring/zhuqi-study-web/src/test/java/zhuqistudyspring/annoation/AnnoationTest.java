package zhuqistudyspring.annoation;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuqi at 2020/8/19
 */
public class AnnoationTest {

    /**
     * 测试:component
     */
    @Test
    public void test(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        UserAnnoationEnttiy user = (UserAnnoationEnttiy) ctx.getBean("userAnnoationEnttiy");
        System.out.println("user = " + user);
        Assert.assertNotNull(user);
    }


    /**
     * 测试:Configuration注解
     */
    @Test
    public void test1(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext("zhuqistudyspring");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }
}
