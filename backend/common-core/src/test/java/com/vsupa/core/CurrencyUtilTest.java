package com.vsupa.core;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-01-17 17:35
 * @since   1.0.0
 */
public class CurrencyUtilTest {

    @Test
    public void parseToCent() {
        Long    rst;

        rst = CurrencyUtil.parseToCent("0.01");
        Assert.assertEquals((Long)1L, rst);

        rst = CurrencyUtil.parseToCent("10.01");
        Assert.assertEquals((Long)1001L, rst);
    }
}