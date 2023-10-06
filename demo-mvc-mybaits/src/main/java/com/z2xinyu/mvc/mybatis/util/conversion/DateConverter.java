package com.z2xinyu.mvc.mybatis.util.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理参数格式，入参绑定
 * 日期 string-》date
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if(StringUtils.isEmpty(source)) {
            throw new NullPointerException("请传入正确的数据");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 解析字符串，转成日期对象
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("请输入正确的日期格式，参考yyyy-MM-dd");
        }
    }
}
