package com.vsupa.security;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Maxwell.Lee
 * @date 2018-01-18 14:59
 * @since   1.0.0
 */
public class DigestUtilTest {

    @Test
    public void md5() {
        String  actual;

        actual = DigestUtil.md5("hello");
        System.out.println(actual);
        Assert.assertEquals("5d41402abc4b2a76b9719d911017c592", actual);

        actual = DigestUtil.md5("HELLO");
        System.out.println(actual);
        Assert.assertEquals("eb61eead90e3b899c6bcbe27ac581660", actual);
    }

    @Test
    public void md5WithSalt() {
        String  actual;

        actual = DigestUtil.md5("hello", "12345678");
        System.out.println(actual);
        Assert.assertEquals("df9fef87421f8fefdfdd2c177d461995", actual);

        actual = DigestUtil.md5("HELLO", "");
        System.out.println(actual);
        Assert.assertEquals("eb61eead90e3b899c6bcbe27ac581660", actual);
    }

    @Test
    public void sha1() {
        String  actual;

        actual = DigestUtil.sha1("hello");
        System.out.println(actual);
        Assert.assertEquals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d", actual);

        actual = DigestUtil.sha1("HELLO");
        System.out.println(actual);
        Assert.assertEquals("c65f99f8c5376adadddc46d5cbcf5762f9e55eb7", actual);
    }

    @Test
    public void sha256() {
        String  actual;

        actual = DigestUtil.sha256("hello");
        System.out.println(actual);
        Assert.assertEquals("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824", actual);

        actual = DigestUtil.sha256("HELLO");
        System.out.println(actual);
        Assert.assertEquals("3733cd977ff8eb18b987357e22ced99f46097f31ecb239e878ae63760e83e4d5", actual);
    }
}