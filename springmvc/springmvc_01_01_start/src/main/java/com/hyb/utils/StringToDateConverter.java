package com.hyb.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     *
     * @param source 传入的字符串的值
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source == null) {
            throw new RuntimeException("请传入数据");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转日期
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转换出现异常");
        }
    }
}
