package com.z2xinyu.mvc.mybatis.util.filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一处理get和post请求字符编码问题，tomcat8之后默认URIEncoding为UTF-8
 */
public class GenericEncodingFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // 获取init-param的编码参数
        String charset = this.getFilterConfig().getInitParameter("charset");
        if(StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        // 处理POST请求编码，这种方式只对Post请求有效
//        request.setCharacterEncoding(charset);
        // 处理GET请求编码，对请求的Request进行装饰
        EncodingRequest encodingRequest = new EncodingRequest(request, charset);
        // 统一处理响应编码
        response.setContentType("text/html;charset=" + charset);
        filterChain.doFilter(encodingRequest, response);
    }
}
