package com.vsupa.core;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-02-05 19:56
 * @since   1.0.0
 */
public class SensitiveInfoMaskTest {

    @Test
    public void maskMobile() {
        Assert.assertEquals("123****4321", SensitiveInfoMask.maskMobile("12300004321"));
        Assert.assertEquals(null, SensitiveInfoMask.maskMobile("12300004321="));
        Assert.assertEquals(null, SensitiveInfoMask.maskMobile("12300"));
    }
}