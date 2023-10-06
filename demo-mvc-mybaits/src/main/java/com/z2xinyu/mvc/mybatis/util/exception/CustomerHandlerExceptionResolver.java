package com.z2xinyu.mvc.mybatis.util.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 程序中发生的异常被DispatcherServlet交给ExceptionResolver进行统一管理
 *
 * @author zxy
 * @version v1.0
 * @date created in 2021-11-26 23:33
 */
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    /**
     * @param handler 发生异常的信息位置   包名+类名+方法名（形参） 字符串
     * @param ex      具体的异常对象
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String message = null;
        // 预期异常
        if (ex instanceof MessageException) {
            message = ex.getMessage();
        } else {
            // 得到其它异常信息的字符串
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            ex.printStackTrace(printWriter);
            message = stringWriter.toString();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
