package com.z2xinyu.aop.aspect.coding;

import com.z2xinyu.aop.annotation.ApiLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 如果一场演出没有观众的话，那不能称之为演出。对不对？从演出的角度来看，观众是非常重要的，但是对演出本身的功能来讲，它并不是核心，
 * 这是一个单独的关注点。因此，将观众定义为一个切面，并将其应用到演出上就是较为明智的做法。
 *
 */
@Aspect
@Slf4j
public class Audience {
    @Pointcut(value = "execution(* com.z2xinyu.aop.concert.Performance.*(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones(JoinPoint joinPoint) throws NoSuchMethodException {
        // PerformanceImpl@2553
        Object target = joinPoint.getTarget();
        log.info("target--" + target);

        // 生成的代理对象
        Object aThis = joinPoint.getThis();
        log.info("this--" + target);

        Object[] args = joinPoint.getArgs();
        log.info("args--" + Arrays.toString(args));

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        // 获取方法上的注解
        Method method1 = joinPoint.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
        ApiLog annotation = method1.getAnnotation(ApiLog.class);
        String title = annotation.title();
        log.info(target.getClass().getName() + "-" + annotation.annotationType().getName() + "-title：" +  title);
        log.info("Annotations-" + Arrays.asList(method1.getAnnotations()));

        log.info("演出开始之前，手机静音 Silencing cell phones");
    }

    @Before("performance()")
    public void takeSeats() {
        log.info("演出开始之前：坐，Taking seats");
    }

    /**
     * 演出成功返回后，调用
     *
     * args绑定目标方法的参数值
     * returning指定目标方法的返回值，将返回值绑定到通知方法指定名称的参数中，
     * 注：参数类型会限定目标方法的返回类型（如果目标方法或返回值的类型非通知方法指定的参数类型的实现，返回通知不会执行）

     */
    @AfterReturning(pointcut = "execution(* com.z2xinyu.aop.concert.Performance.performance(String)) && args(show)", returning = "result", argNames = "show,result")
    public void applause(String show, int result) {
        log.info("args: {}, return: {}", show, result);
        log.info("演出很精彩，观众鼓掌喝彩 clap clap clap");
    }

    @AfterThrowing(pointcut = "performance()", throwing = "e")
    public void demandRefund(Exception e) {
        log.info("演出失败，观众要求退票 Demanding a refund");
    }
}
