package com.z2xinyu.aop.aspect.coding;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 使用@Around替代
 */
@Aspect
@Slf4j
//@Component
public class AudienceAround {

    @Pointcut(value = "execution(* com.z2xinyu.aop.concert.Performance.*(..))")
    public void performance() {
    }

    @Around("performance()")
    public Object watchePerformance(ProceedingJoinPoint pj) {
        Object obj = null;
        try {
            // before
            log.info("silencing cell phones");
            log.info("taking seats");
            // 执行目标方法
            obj = pj.proceed();
            // after return
            log.info("CLAP CLAP CLAP");
        } catch (Throwable e) {
            // rnm, 退钱！
            log.info("Demanding a refund");
        } finally {
            log.info("must be");
        }
        return obj;
    }
}
