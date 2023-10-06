package com.z2xinyu.mybatis.config.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.logging.Log;

/**
 * mybatis配置日志：https://mybatis.org/mybatis-3/zh/logging.html
 *
 * @author Arnoer
 * @since 2022/9/23 14:21
 */
@Slf4j
public class CustomSlf4jImpl implements Log {

    public CustomSlf4jImpl(String clazz) {
        // Do Nothing
    }


    @Override
    public boolean isDebugEnabled() {
        // return log.isDebugEnabled();
        // 将debug级别输出权限改成info级别
        return log.isInfoEnabled();

    }


    @Override
    public void debug(String s) {
        // log.debug(s);
        // debug日志输出成info级别日志
        log.info(s);
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void error(String s, Throwable e) {
        System.err.println(s);
        e.printStackTrace(System.err);
    }

    @Override
    public void error(String s) {
        System.err.println(s);
    }

    @Override
    public void trace(String s) {
        System.out.println(s);
    }

    @Override
    public void warn(String s) {
        System.out.println(s);
    }

}
