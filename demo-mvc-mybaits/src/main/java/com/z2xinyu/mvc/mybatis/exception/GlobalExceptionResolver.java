package com.z2xinyu.mvc.mybatis.exception;

import com.z2xinyu.mvc.mybatis.api.ErrorCode;
import com.z2xinyu.mvc.mybatis.api.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局Controller层异常处理类  @controllAdvice和@restController的结合
 */
@RestControllerAdvice
public class GlobalExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);

    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {

        return R.fail(ErrorCode.UNKNOWN_ERROR, e.getMessage());
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(BusinessException.class)
    public R handleOpdRuntimeException(BusinessException e) {
        return R.fail(e.getMsg());
    }

    /**
     * 异常的处理方式
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity Not Found")
    // 另一种方式是加在异常类上，返回的响应体就是@ResponseStatus指定的信息，而不是return
    public R entityNotFound(EntityNotFoundException e) {
        long entityId = e.getEntityId();
        return R.fail(ErrorCode.USERNAME_ERROR, "entityId" + entityId);
    }

}

