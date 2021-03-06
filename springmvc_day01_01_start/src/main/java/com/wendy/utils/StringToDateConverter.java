package com.wendy.utils;
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
     * s  传入进来字符串
     * @param s
     * @return
     */
    @Override
    public Date convert(String s) {
        if (s == null){
            throw new RuntimeException("请传入数据");
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把字符串转换成日期
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
       // return null;
    }
}
