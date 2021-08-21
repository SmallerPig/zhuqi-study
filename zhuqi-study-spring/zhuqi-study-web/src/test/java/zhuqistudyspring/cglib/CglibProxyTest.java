package zhuqistudyspring.cglib;

import zhuqistudyspring.UserService;
import zhuqistudyspring.UserServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhuqi at 2020/8/15
 */
public class CglibProxyTest {

    private static final Logger log = LoggerFactory.getLogger(CglibProxyTest.class);
    /**
     * 测试:测试Cglib创建动态代理类方法
     */
    @Test
    public void test(){

        UserServiceImpl userService = new UserServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CglibProxyTest.class.getClassLoader());
        enhancer.setSuperclass(UserServiceImpl.class);

        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                log.debug("-------------- CglibProxyTest.intercept -------------");
                return method.invoke(userService, objects);
            }
        };

        enhancer.setCallback(methodInterceptor);
        UserServiceImpl o = (UserServiceImpl) enhancer.create();
        o.login("zhuqi", "123456");
    }
}
