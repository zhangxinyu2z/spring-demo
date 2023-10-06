package com.z2xinyu.mvc.mybatis.util.interceptor;

import com.z2xinyu.mvc.mybatis.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * 未登录的用户，拦截返回登录页面
 *
 * @author zxy
 * @version v1.0
 * @date created in 2021-11-28 17:14
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String requestURI = request.getRequestURI();
        logger.info("preHandle: {}", requestURI);
        //  请求地址中不包含login的地址需要检查
        if (!requestURI.contains("user/login")) {
            User user = (User)request.getSession().getAttribute("session_user");
            if (user == null) {
                response.sendRedirect(request.getContextPath() + "/user/login");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {

    }
}
