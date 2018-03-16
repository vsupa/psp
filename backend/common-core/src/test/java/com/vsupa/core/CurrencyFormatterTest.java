package com.vsupa.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Maxwell.Lee
 * @date 2018-01-10 16:59
 * @since   1.0.0
 */
public class CurrencyFormatterTest {

    @Test
    public void formatFen() {
        String rst;

        rst = CurrencyFormatter.formatCent(10001L);
        Assert.assertEquals("100.01", rst);

        rst = CurrencyFormatter.formatCent(10051L);
        Assert.assertEquals("100.51", rst);

        rst = CurrencyFormatter.formatCent(-10001L);
        Assert.assertEquals("-100.01", rst);

        rst = CurrencyFormatter.formatCent(-10051L);
        Assert.assertEquals("-100.51", rst);

        rst = CurrencyFormatter.formatCent(10000L);
        Assert.assertEquals("100.00", rst);

        rst = CurrencyFormatter.formatCent(-10000L);
        Assert.assertEquals("-100.00", rst);



        rst = CurrencyFormatter.formatCent(1L);
        Assert.assertEquals("0.01", rst);

        rst = CurrencyFormatter.formatCent(51L);
        Assert.assertEquals("0.51", rst);

        rst = CurrencyFormatter.formatCent(-1L);
        Assert.assertEquals("-0.01", rst);

        rst = CurrencyFormatter.formatCent(-51L);
        Assert.assertEquals("-0.51", rst);

        rst = CurrencyFormatter.formatCent(0L);
        Assert.assertEquals("0.00", rst);

        rst = CurrencyFormatter.formatCent(-0L);
        Assert.assertEquals("0.00", rst);
    }
}