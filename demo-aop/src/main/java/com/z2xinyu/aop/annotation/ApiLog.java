package com.z2xinyu.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author James
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
/*仅作为标识，javadoc*/
@Documented
public @interface ApiLog
{
    /**
     * 模块 
     */
    String title() default "";

    /**
     * 日志记录service实现
     * @return
     */
    String logService() default "operLogServiceImpl";


    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否追踪用户操作
     * @return
     */
    boolean isTrack() default true;
}

