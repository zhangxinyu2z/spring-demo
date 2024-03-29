package com.z2xinyu.mvc.mybatis.util.exception;

/**
 * 自定义的预期异常
 *
 * @author zxy
 * @version v1.0
 * @date created in 2021-11-26 23:34
 */
public class MessageException extends Exception{
    public MessageException() {
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }

    public MessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
