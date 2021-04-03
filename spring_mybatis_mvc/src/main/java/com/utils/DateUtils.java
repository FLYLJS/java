package com.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

public class DateUtils implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        if (StringUtils.isEmpty(source)) {throw new RuntimeException("请传入日期");}
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(source, "yyyy-MM-dd");
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误"+"\n"+e);
        }
    }

    public static void main(String[] args) {
        System.out.println(System.getenv());

    }
}
