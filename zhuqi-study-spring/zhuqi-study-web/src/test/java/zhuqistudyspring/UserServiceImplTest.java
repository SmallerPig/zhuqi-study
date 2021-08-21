package zhuqistudyspring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @author zhuqi at 2020/8/13
 */
public class UserServiceImplTest {

    @Test
    public void testLogin() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("zhuqi", "123456");

    }
}
