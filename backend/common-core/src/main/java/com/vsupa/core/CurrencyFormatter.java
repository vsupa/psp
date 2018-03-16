package com.vsupa.core;

/**
 * 货币格式化工具
 * @author Maxwell.Lee
 * @date 2018-01-10 16:50
 * @since   1.0.0
 */
public class CurrencyFormatter {

    /**
     * 格式化货币的输出
     * @param currencyOfUnitCent   货币额度，单位：分；
     * @return  输出单位为元
     */
    public static String formatCent(Long currencyOfUnitCent) {
        if (currencyOfUnitCent == null) return null;//"-.-"

        long c = Math.abs(currencyOfUnitCent);
        long yunPart = (long) Math.floor(c * 0.01);
        int fenPart = (int) Math.abs(c - yunPart * 100);

        if (currencyOfUnitCent >= 0) {
            return String.format("%01d.%02d", yunPart, fenPart);
        } else {
            return String.format("-%01d.%02d", yunPart, fenPart);
        }
    }

}
