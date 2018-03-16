package com.vsupa.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期时间工具类
 * @author Maxwell.Lee
 * @date 2018-01-12 11:31
 * @since   1.0.0
 */
public class DateTimeUtil {

    /**
     * 识别：2017-1-1, 2017-01-01, 2017/01/01, 2017/1/1；
     */
    private static final Pattern DateRegxOfYYYYMMDDWithSeparator = Pattern.compile("([0-9]{4})[-/]([0-9]{1,2})[-/]([0-9]{1,2})");
    /**
     * 识别：20170101
     */
    private static final Pattern DateRegxOfYYYYMMDD = Pattern.compile("([0-9]{4})([0-9]{2})([0-9]{2})");

    /**
     * 识别：2017-1, 2017-01, 2017/01, 2017/1；
     */
    private static final Pattern DateRegxOfYYYYMMWithSeparator = Pattern.compile("([0-9]{4})[-/]([0-9]{1,2})");
    /**
     * 识别：201701
     */
    private static final Pattern DateRegxOfYYYYMM = Pattern.compile("([0-9]{4})([0-9]{2})");

    /**
     * 解释日期的字符串；
     * @param dateStr   日期字符串，例如：2017-1-1, 2017-01-01, 2017/01/01, 2017/1/1, 20170101
     * @return  对应的日期的0点0分0秒；
     */
    public static Date parseDateOnly(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;

        Matcher m;

        m = DateRegxOfYYYYMMDDWithSeparator.matcher(dateStr);
        if (m.find()) {
            return buildDate(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)) + 1, Integer.parseInt(m.group(3)));
        }

        m = DateRegxOfYYYYMMDD.matcher(dateStr);
        if (m.find()) {
            return buildDate(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)) + 1, Integer.parseInt(m.group(3)));
        }

        return null;
    }

    /**
     * 解释日期的字符串：包括年份和月份；
     * @param dateStr   日期字符串，例如：2017-1, 2017-01, 2017/01, 2017/1, 201701
     * @return  对应的年月的1号0点0分0秒；
     */
    public static Date parseMonthOnly(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) return null;

        Matcher m;

        m = DateRegxOfYYYYMMWithSeparator.matcher(dateStr);
        if (m.find()) {
            return buildDate(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))  + 1, 1);
        }

        m = DateRegxOfYYYYMM.matcher(dateStr);
        if (m.find()) {
            return buildDate(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))  + 1, 1);
        }

        return null;
    }

    /**
     * 创建日期对象
     * @param year      年份
     * @param month     月份，IndexByOne；
     * @param date      日期
     * @param hour      小时
     * @param minute    分
     * @param second    秒
     * @return  日期对象
     */
    public static Date  buildDate(int year, int month, int date, int hour, int minute, int second) {
        Calendar    calendar = Calendar.getInstance();

        calendar.set(year, month - 1, date, hour, minute, second);

        return calendar.getTime();
    }

    /**
     * 创建日期对象
     * @param year      年份
     * @param month     月份，IndexByOne；
     * @param date      日期
     * @return  日期对象
     */
    public static Date  buildDate(int year, int month, int date) {
        return buildDate(year, month - 1, date, 0, 0, 0);
    }

    /**
     * 对输入的日期执行加减月份的操作；
     * @param date      日期，（必要）；
     * @param delta     加减值，单位：月；
     * @return  结果日期；
     */
    public static Date addMonth(Date date, int delta) {
        Calendar    cal = Calendar.getInstance();

        cal.setTime(date);
        cal.add(Calendar.MONTH, delta);

        return cal.getTime();
    }

    /**
     * 对输入的日期执行加减秒的操作；
     * @param date      日期，（必要);
     * @param seconds   加减值，单位：秒；
     * @return  结果日期；
     */
    public static Date  addSeconds(Date date, int seconds) {
        return new Date(date.getTime() + seconds * 1000L);
    }

    /**
     * 格式化日期输出
     * @param date      日期时间，（必要）；
     * @return  yyyymmdd格式的字符串；
     */
    public static String formatAsYYYYMMDD(Date date) {
        if (date == null) return  null;
        Calendar    cal = Calendar.getInstance();
        cal.setTime(date);

        return String.format("%04d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
                             cal.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 移除日期字符串中，没有意义的部分；
     * @param dateTimeStr       日期和时间字符串，（必要);
     * @return  日期时间字符串；
     */
    public static String removeMeaninglessPart(String dateTimeStr) {
        if (dateTimeStr == null) return null;

        return dateTimeStr.replaceAll("T00:00:00", "");
    }
}
