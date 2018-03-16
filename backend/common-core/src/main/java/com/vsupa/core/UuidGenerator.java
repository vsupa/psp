package com.vsupa.core;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 通用的UUID生成器，UUID格式：大写字母和数字；
 *
 * @author Maxwell.Lee
 * @date 2018-01-15 14:34
 * @since   1.0.0
 */
public class UuidGenerator {

    private static final char[] map = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    private int     size;

    private byte[]  buf;

    private SecureRandom    ng = new SecureRandom();

    public UuidGenerator(int size) {
        this.size = size;
        this.buf = new byte[size / 2];
    }

    public UuidGenerator() {
        this(32);
    }

    public String   next() {
        ng.nextBytes(buf);

        return encode(buf);
    }

    private static String encode(byte[] buf) {
        char[] chars = new char[buf.length * 2];

        for (int i = 0, j = 0; i < buf.length; i++, j += 2) {
            byte b = buf[i];

            chars[j] = map[b & 0x0f];
            chars[j + 1] = map[(b >> 4) & 0x0f];
        }

        chars[10] = '-';
        chars[20] = '-';

        return new String(chars);
    }

}
