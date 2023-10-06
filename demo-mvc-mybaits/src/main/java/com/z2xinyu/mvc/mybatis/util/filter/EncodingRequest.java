package com.z2xinyu.mvc.mybatis.util.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 用来装饰HttpRequest，处理请求编码问题。
 */
public class EncodingRequest extends HttpServletRequestWrapper {
    /**
     * 是否再对请求参数进行一次编码、解码
     */
    private boolean hasEncoded;
    /**
     * 字符编码
     */
    private String charset;
    /**
     * 方便内部方法调用
     */
    private HttpServletRequest request;

    public EncodingRequest(HttpServletRequest request, String charset) {
        super(request);
        this.charset = charset;
        // 方便调用
        this.request = request;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        // this.getRequest(); 得到的是请求的request，而不是包装的EncodingRequest
        Map<String, String[]> parameterMap = request.getParameterMap();
        if ("get".equalsIgnoreCase(request.getMethod())) {
            if (!hasEncoded) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    String[] values = entry.getValue();
                    for (int i = 0; i < values.length; i++) {
                        try {
                            values[i] = new String(values[i].getBytes("iso-8859-1"), charset);
                        } catch (UnsupportedEncodingException e) {
                            // stop running
                            throw new RuntimeException(e);
                        }
                    }
                }
                hasEncoded = false;
            }
        } else if("post".equalsIgnoreCase(request.getMethod())) {
            try {
                request.setCharacterEncoding(charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return parameterMap;
    }

    @Override
    public String[] getParameterValues(String name) {
        return this.getParameterMap().get(name);
    }

    @Override
    public String getParameter(String name) {
        return this.getParameterValues(name) == null ? null : this.getParameterValues(name)[0];
    }
}
