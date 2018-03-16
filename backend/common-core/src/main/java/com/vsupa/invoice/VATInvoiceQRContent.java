package com.vsupa.invoice;

import java.io.Serializable;
import java.util.Date;

/**
 * 增值税发票左上交二维码内容；
 *
 * @author Maxwell.Lee
 * @date 2018-01-17 16:47
 * @since   1.0.0
 */
public class VATInvoiceQRContent implements Serializable {

    private static final long serialVersionUID = -8203758452100186008L;

    private String      typeCode;

    private String      invoiceCode;

    private String      invoiceNo;

    private Long        amountWithoutTax;

    private Date        billingDate;

    private String      verifyCode;

    private String      secretCode;

    public VATInvoiceQRContent(String typeCode, String invoiceCode, String invoiceNo, Long amountWithoutTax,
                               Date billingDate, String verifyCode, String secretCode) {
        this.typeCode = typeCode;
        this.invoiceCode = invoiceCode;
        this.invoiceNo = invoiceNo;
        this.amountWithoutTax = amountWithoutTax;
        this.billingDate = billingDate;
        this.verifyCode = verifyCode;
        this.secretCode = secretCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public Long getAmountWithoutTax() {
        return amountWithoutTax;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public String getSecretCode() {
        return secretCode;
    }

    @Override
    public String toString() {
        return "VATInvoiceQRContent{" +
                "typeCode='" + typeCode + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", amountWithoutTax=" + amountWithoutTax +
                ", billingDate=" + billingDate +
                ", verifyCode='" + verifyCode + '\'' +
                ", secretCode='" + secretCode + '\'' +
                '}';
    }
}
