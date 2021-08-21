package zhuqistudyspring.Interceptor;

import zhuqistudyspring.annoation.OrgCheck;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zhuqi at 2020/8/13
 */
public class OrgCheckArround implements MethodBeforeAdvice {
    private static final Logger log = LoggerFactory.getLogger(OrgCheckArround.class);

    /**
     * Callback before a given method is invoked.
     *
     * @param method method being invoked
     * @param args   arguments to the method
     * @param target target of the method invocation. May be {@code null}.
     * @throws Throwable if this object wishes to abort the call.
     *                   Any exception thrown will be returned to the caller if it's
     *                   allowed by the method signature. Otherwise the exception
     *                   will be wrapped as a runtime exception.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
//        OrgCheck annotation = method.getAnnotation(OrgCheck.class);
//        log.debug("annotation.orgId() = " + annotation.orgId());
    }
}
