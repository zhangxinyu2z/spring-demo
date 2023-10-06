package com.z2xinyu.mvc.mybatis.exception;

import com.z2xinyu.mvc.mybatis.api.ErrorCode;
import lombok.Data;

/**
 * 自定义业务异常
 * @author Zhang Xinyu
 */
@Data
public class BusinessException extends RuntimeException {
    private final String msg;

    /**
     * 主动抛出的api业务类异常编码
     */
    private final long code;

    public BusinessException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

}

