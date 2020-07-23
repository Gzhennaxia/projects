package com.gzhennaxia.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bo li
 * @date 2020-07-22 14:23
 */
public class DateUtils {

    public static Date parse(String s) {
        Date date;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }
}
