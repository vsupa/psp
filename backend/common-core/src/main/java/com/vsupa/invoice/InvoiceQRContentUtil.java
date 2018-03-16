package com.vsupa.invoice;


import com.vsupa.core.CurrencyUtil;
import com.vsupa.core.DateTimeUtil;

import java.util.Date;

/**
 * 发票左上角二维码内容工具类；
 * 内容格式：逗号分隔的字符串（数字和英文字母）；
 * @author Maxwell.Lee
 * @date 2018-01-17 16:43
 * @since   1.0.0
 */
public class InvoiceQRContentUtil {

    private static final String     Separator = ",";

    public static String prepare(String qrStr) {
        if (qrStr == null) return null;

        return qrStr.replaceAll(" ", "");
    }

    /**
     * 解释增值税发票左上角二维码内容；
     * <br>例子：01,04,1200153320,07041662,183.49,20151221,83623873463907646339,5080
     * <br>解释：01,04（01,04是普通发票，01,01是专用发票）,1200153320（发票代码）,07041662（发票号码）,183.49（不含税金额）,
     *          20151221（开票日期）,83623873463907646339（校验码）,5080（随机产生的机密信息）
     * @param qrStr     二维码解码后的字符串，（必要）；
     * @return  增值税发票二维码内容；
     */
    public static VATInvoiceQRContent   parseVATQRContent(String qrStr) {
        if (qrStr == null) return null;

        String[]    fields = qrStr.split(Separator);
        if (fields.length < 7 || !fields[0].equals("01")) return null;

        Long amountWithoutTax = CurrencyUtil.parseToCent(fields[4]);
        Date billingDate = DateTimeUtil.parseDateOnly(fields[5]);
        String sCode = (fields.length > 7 ? fields[7] : null);

        return new VATInvoiceQRContent(fields[1], fields[2], fields[3], amountWithoutTax, billingDate, fields[6], sCode);
    }

}
