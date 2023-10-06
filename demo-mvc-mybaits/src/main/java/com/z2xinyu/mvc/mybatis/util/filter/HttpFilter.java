package com.z2xinyu.mvc.mybatis.util.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 提供一个Filter接口的扩展实现，用来子类化
 * 1. 关联了filterConfig，方便调用
 * 2. 扩展了自定义的dofilter方法，用来处理request和response，进行编码处理
 *
 * @author xy
 */
public abstract class HttpFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    /**
     * 子类用来初始化的方法
     */
    protected void init() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        this.doFilter(req, resp, chain);
    }

    /**
     * 过滤器处理功能的逻辑，要求子类必须实现
     */
    public abstract void doFilter(HttpServletRequest request,
                                  HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException;


    @Override
    public void destroy() {
    }
}
