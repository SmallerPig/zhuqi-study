package zhuqistudyspring.Interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author zhuqi at 2020/8/12
 */
public class Arround implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MyMethodInterceptor.invoke");
        Object proceed = methodInvocation.proceed();
        return proceed;
    }
}
