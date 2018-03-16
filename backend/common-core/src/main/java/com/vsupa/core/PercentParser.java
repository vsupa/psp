package com.vsupa.core;

/**
 * 百分比解释器；
 * @author Maxwell.Lee
 * @date 2018-01-22 11:35
 * @since   1.0.0
 */
public class PercentParser {

    public static Integer parseToPTT(String str) {
        if (str == null) return null;

        if (str.endsWith("%")) {
            Double val = Double.parseDouble(str.replaceAll("%", ""));
            return (int)Math.round(val * 100);
        } else if (str.endsWith("‰")) {
            Double val = Double.parseDouble(str.replaceAll("‰", ""));
            return (int)Math.round(val * 10);
        } else if (str.endsWith("‱")) {
            Double val = Double.parseDouble(str.replaceAll("‱", ""));
            return (int)Math.round(val);
        }

        return null;
    }

    /**
     * 百分率转万分率；
     * @param percent   百分率，（必要）；
     * @return  万分率；
     */
    public static Integer percentToPTT(Double percent) {
        return (percent != null ? (int) Math.round(percent * 100) : null);
    }

}
