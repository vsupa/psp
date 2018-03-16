//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.vsupa.velocity;

import java.util.Date;

public class RelativeDateFormat {
    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;
    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public RelativeDateFormat() {
    }

    public static String format(Date date) {
        long delta = (new Date()).getTime() - date.getTime();
        long years;
        if(delta < 60000L) {
            years = toSeconds(delta);
            return (years <= 0L?1L:years) + "秒前";
        } else if(delta < 2700000L) {
            years = toMinutes(delta);
            return (years <= 0L?1L:years) + "分钟前";
        } else if(delta < 86400000L) {
            years = toHours(delta);
            return (years <= 0L?1L:years) + "小时前";
        } else if(delta < 172800000L) {
            return "昨天";
        } else if(delta < 2592000000L) {
            years = toDays(delta);
            return (years <= 0L?1L:years) + "天前";
        } else if(delta < 29030400000L) {
            years = toMonths(delta);
            return (years <= 0L?1L:years) + "月前";
        } else {
            years = toYears(delta);
            return (years <= 0L?1L:years) + "年前";
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }
}
