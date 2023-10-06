package com.z2xinyu.mvc.mybatis.api;

import lombok.Getter;

import java.text.MessageFormat;

/**
 * @author Arnoer
 * @since 2022/10/9 16:40
 */
public enum ErrorCode implements IResultCode {

    /**
     * 未知错误
     */
    UNKNOWN_ERROR(10001, "unknown error"),

    /**
     * 用户名错误或不存在
     */
    USERNAME_ERROR(10002, "username error or does not exist"),

    /**
     * 密码错误
     */
    PASSWORD_ERROR(10003, "password error"),

    /**
     * 用户名不能为空
     */
    USERNAME_EMPTY(10004, "username can not be empty"),

    INFO_CASE(1005, "{0}获取参数{1}失败");


    /**
     * 结果码
     */
    @Getter
    private int code;

    /**
     * 结果码描述
     */
    private String msg;

    private String[] msgs;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        if (msgs != null) {
            return MessageFormat.format(msg, msgs);
        }
        return msg;
    }

    public ErrorCode setMsgs(String[] msgs) {
        this.msgs = msgs;
        return this;
    }

    public static void main(String[] args) {
        System.out.println(ErrorCode.INFO_CASE.setMsgs(new String[]{"getWord", "xxx"}).getMessage());
    }
}
