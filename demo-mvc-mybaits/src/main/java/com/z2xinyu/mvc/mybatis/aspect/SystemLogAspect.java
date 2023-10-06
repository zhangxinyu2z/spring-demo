package com.z2xinyu.mvc.mybatis.aspect;

import com.z2xinyu.mvc.mybatis.annotation.LogAnnotation;
import com.z2xinyu.mvc.mybatis.util.IpAddressHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 日志说明：https://www.cnblogs.com/lujiango/p/8573411.html
 */
@Aspect
@Component
public class SystemLogAspect {
    /**
     * log object
     */
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    /**
     * 在有该注解的方法切入增强
     */
    @Pointcut("@annotation(com.z2xinyu.mvc.mybatis.annotation.LogAnnotation)")
    public void apiPointCut() {
    }

    @Before(value = "apiPointCut()")
    public void doBefore(JoinPoint joinpoint) {
        logger.info("from SystemLogAspect.doBefore()");
        handleLog(joinpoint, null);
    }

    @AfterThrowing(value = "apiPointCut()", throwing = "e")
    public void doError(JoinPoint joinpoint, Exception e) {
        logger.info("from SystemLogAspect.doError()");
        handleLog(joinpoint, e);
    }

    @After(value = "apiPointCut()")
    public void doAfter() {
        logger.info("from systemLogAspect.doAfter()");
    }

    @AfterReturning(value = "apiPointCut()")
    public void doAfterReturning(JoinPoint joinpoint) {
        logger.info("from SystemLogAspect.doAfterReturning()");
    }

    @Around(value = "apiPointCut()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        logger.info("doAround.before");
        try {
            return jp.proceed();
        } catch (Throwable e) {
            logger.info("doAround.error:{}", e.getMessage());
            throw e;
        } finally {
            logger.info("doAround.after");
        }
    }

    private void handleLog(JoinPoint joinpoint, Exception e) {
        LogAnnotation logAnnotation = getLogAnnotation(joinpoint);
        if (logAnnotation == null) {
            return;
        }
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        String ipAddress = "127.0.0.1";
        String device = "BROWSER";
        if (requestAttributes != null) {
            HttpServletRequest request =
                ((ServletRequestAttributes)Objects.requireNonNull(requestAttributes)).getRequest();
            ipAddress = IpAddressHelper.getIpAddress(request);
            //            ipAddress = request.getRemoteAddr();
            device = request.getHeader("User-Agent");
        }

        // @LogAnnotation标识的描述
        String desc = logAnnotation.desc();
        if ("query".equals(desc)) {
            //            String s = joinpoint.getArgs()[0].toString();
            logger.info("desc:{}, ip:{}", desc, ipAddress);
        } else {
            logger.error("desc:{}, ip:{}, error msg:{}", desc, ipAddress, e.getMessage());
        }
    }

    /**
     * 获取连接点上的注解，即Controller方法上的log注解
     *
     * @param joinpoint
     * @return
     */
    private LogAnnotation getLogAnnotation(JoinPoint joinpoint) {
        MethodSignature methodSignature = (MethodSignature)joinpoint.getSignature();
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(LogAnnotation.class);
        }
        return null;
    }

}
