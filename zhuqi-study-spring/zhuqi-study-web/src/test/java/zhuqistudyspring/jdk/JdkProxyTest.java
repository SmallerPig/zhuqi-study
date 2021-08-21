package zhuqistudyspring.jdk;

import zhuqistudyspring.UserService;
import zhuqistudyspring.UserServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zhuqi at 2020/8/15
 */
public class JdkProxyTest {

    private static final Logger log = LoggerFactory.getLogger(JdkProxyTest.class);

    /**
     * 测试:Proxy
     * 借用类加载器 ClassLoader
     */
    @Test
    public void test(){

        // jdk8.0 之前需要加final 修饰符
        UserService userService = new UserServiceImpl();

        InvocationHandler handler = (proxy, method, args) -> {
            log.debug("args = " + args);
//            log.debug("proxy = " + proxy + ", method = " + method + ", args = " + Arrays.deepToString(args));
            Object invoke = method.invoke(userService, args);
            return invoke;
        };

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), handler);

        userServiceProxy.login("zhuqi", "123456");

    }
}
