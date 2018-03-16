package com.vsupa.core;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-01-12 11:46
 * @since   1.0.0
 */
public class DateTimeUtilTest {

    @Test
    public void parseDateOnly() {
        System.out.println(DateTimeUtil.parseDateOnly("2017-01-01"));
        System.out.println(DateTimeUtil.parseDateOnly("2017-1-1"));
        System.out.println(DateTimeUtil.parseDateOnly("2017-01-01T"));
        System.out.println(DateTimeUtil.parseDateOnly(" 2017-01-01"));
        System.out.println(DateTimeUtil.parseDateOnly(" 20170101"));
        System.out.println(DateTimeUtil.parseDateOnly("2017-Feb-01"));
    }

    @Test
    public void parseMonthOnly() {
        System.out.println(DateTimeUtil.parseMonthOnly("2017-01-01"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-1-1"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-01-01T"));
        System.out.println(DateTimeUtil.parseMonthOnly(" 2017-01-01"));
        System.out.println(DateTimeUtil.parseMonthOnly(" 20170101"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-Feb-01"));

        System.out.println(DateTimeUtil.parseMonthOnly("2017-01"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-1"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-01"));
        System.out.println(DateTimeUtil.parseMonthOnly(" 2017-01"));
        System.out.println(DateTimeUtil.parseMonthOnly(" 201701"));
        System.out.println(DateTimeUtil.parseMonthOnly("2017-Feb"));

        System.out.println(DateTimeUtil.parseMonthOnly("2017-012"));
    }

    @Test
    public void addMonth() {
        Date now = new Date();

        System.out.println(DateTimeUtil.addMonth(now, 0));

        System.out.println(DateTimeUtil.addMonth(now, 1));
        System.out.println(DateTimeUtil.addMonth(now, 2));
        System.out.println(DateTimeUtil.addMonth(now, 12));
        System.out.println(DateTimeUtil.addMonth(now, 13));

        System.out.println(DateTimeUtil.addMonth(now, -1));
        System.out.println(DateTimeUtil.addMonth(now, -2));
        System.out.println(DateTimeUtil.addMonth(now, -12));
        System.out.println(DateTimeUtil.addMonth(now, -13));
    }

    @Test
    public void format() {
        String dateStr = DateTimeUtil.formatAsYYYYMMDD(new Date(1516353955748L));
        Assert.assertEquals("20180119", dateStr);
        System.out.println(dateStr);
    }
}