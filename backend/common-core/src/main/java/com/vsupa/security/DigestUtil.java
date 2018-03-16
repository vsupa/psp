package com.vsupa.security;

import com.vsupa.core.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 签名算法工具类，包括：MD5，SHA-1, SHA-256等；
 * @author Maxwell.Lee
 * @date 2018-01-18 14:44
 * @since   1.0.0
 */
public class DigestUtil {

    private static final Charset DefaultCharset = Charset.forName("UTF-8");

    /**
     * MD5签名
     * @param text      需要签名的文本；
     * @return  32个字符和16进制的Lower
     */
    public static String    md5(String text) {
        if (text == null) return null;

        return Hex.encodeToString(md5(text.getBytes(DefaultCharset)));
    }

    /**
     * MD5签名
     * @param text      需要签名的文本，（必要）；
     * @param salt      签名是添加的末尾的盐值，（可选）；
     * @return  32个字符和16进制的Lower
     */
    public static String    md5(String text, String salt) {
        if (text == null) return null;
        if (salt == null) {
            return Hex.encodeToString(md5(text.getBytes(DefaultCharset)));
        }

        return Hex.encodeToString(md5(text.getBytes(DefaultCharset), salt.getBytes(DefaultCharset)));
    }

    /**
     * MD5签名；
     * @param bytes     需要签名的字节；
     * @return  签名后的内容；
     */
    public static byte[]    md5(byte[] bytes) {
        if (bytes == null) return null;
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");

            return md5Digest.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[]    md5(byte[] bytes, byte[] salt) {
        if (bytes == null) return null;
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");

            md5Digest.update(bytes);
            md5Digest.update(salt);

            return md5Digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SHA-1签名；
     * @param text      需要签名的文本；
     * @return  40个字符和16进制的Lower
     */
    public static String    sha1(String text) {
        if (text == null) return null;

        return Hex.encodeToString(sha1(text.getBytes(DefaultCharset)));
    }

    public static byte[]    sha1(byte[] bytes) {
        if (bytes == null) return null;

        try {
            MessageDigest md5Digest = MessageDigest.getInstance("SHA-1");

            return md5Digest.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * SHA-256签名；
     * @param text      需要签名的文本；
     * @return  64个字符和16进制的Lower
     */
    public static String    sha256(String text) {
        if (text == null) return null;

        return Hex.encodeToString(sha256(text.getBytes(DefaultCharset)));
    }

    public static byte[]    sha256(byte[] bytes) {
        if (bytes == null) return null;

        try {
            MessageDigest md5Digest = MessageDigest.getInstance("SHA-256");

            return md5Digest.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
