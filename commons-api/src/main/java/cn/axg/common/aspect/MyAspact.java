package cn.axg.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Classname MyAspact
 * @Description 增强类
 * @Date 2022/1/22 14:44
 * @Created by AN
 */
@Component
@Aspect
public class MyAspact {

    /**
     * 环绕通知增强
     * 对以aop.anno包下的所有类的所有方法进行增强
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* cn.axg.common.*.*(..))")
    public Object arount(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知增强-----前");
        // 执行目标方法
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕通知增强-----后");
        return obj;
    }
}
