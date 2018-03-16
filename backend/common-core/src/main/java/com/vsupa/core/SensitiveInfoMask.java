package com.vsupa.core;

/**
 * 敏感信息掩盖器
 * @author Maxwell.Lee
 * @date 2018-02-05 19:53
 * @since   1.0.0
 */
public class SensitiveInfoMask {

    private static final String MaskForMobile = "****";

    public static String maskMobile(String mobile) {
        if (mobile == null || mobile.length() != 11) return null;

        return mobile.substring(0, 3) + MaskForMobile + mobile.substring(7, 11);
    }

}
