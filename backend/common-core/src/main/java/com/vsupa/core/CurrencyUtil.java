package com.vsupa.core;

import java.math.BigDecimal;

/**
 * 金额工具类；
 * @author Maxwell.Lee
 * @date 2018-01-17 17:24
 * @since   1.0.0
 */
public class CurrencyUtil {

    /**
     * 解释金额字符串，例如："123.45"；
     * @param currency  金额字符串，格式：[0-9]+\.[0-9]{1,2}（必要）；
     * @return  以分为单位的金额；
     */
    public static Long      parseToCent(String currency) {
        if (currency == null) return null;

        return Math.round(Double.parseDouble(currency) * 100);
    }

    /**
     * 货币金额单位换算：分->元；
     * @param cent      金额，单位：分；
     * @return  金额，单位：元；
     */
    public static Double centToYuan(Long cent) {
        return (cent != null ? cent * 0.01 : null);
    }

    /**
     * 货币金额单位换算：元->分；
     * @param yuan      金额，单位：元；
     * @return  金额，单位：分；
     */
    public static Long  yuanToCent(Double yuan) {
        return (yuan != null ? Math.round(yuan * 100L) : null);
    }

    /**
     * 货币金额单位换算：元->分；
     * @param yuan      金额，单位：元；
     * @return  金额，单位：分；
     */
    public static Long  yuanToCent(BigDecimal yuan) {
        return (yuan != null ? Math.round(yuan.doubleValue() * 100L) : null);
    }
}
