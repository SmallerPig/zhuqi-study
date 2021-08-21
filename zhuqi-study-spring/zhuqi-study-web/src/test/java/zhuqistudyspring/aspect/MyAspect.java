package zhuqistudyspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 增加了Aspect注解就说明是切面类
 *
 *  1. 额外功能,
 *  2. 切入点
 *
 *  需要在xml文件里增加<aop:aspectj-autoproxy /> 来告知spring开启这种注解方式的切面
 * @author zhuqi at 2020/8/15
 */
@Aspect
public class MyAspect {

    private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

    /**
     *
     * 相当于原始方法的使用方式:
     *  public Object invoke(MethodInvocation methodInvocation){
     *      Object ret = methodInvocation.proceed();
     *      return ret;
     *  }
     *
     *
     *
     *
     * 2. 切入点的问题:
     * <aop:config
     *  <aop:pointcut id="" expression= "execution(* login(..))" />
     * @param proceedingJoinPoint
     * @return
     */
    @Around("execution(* login(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("MyAspect.arround");

        return proceedingJoinPoint.proceed();

    }
}
