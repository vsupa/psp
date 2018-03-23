package com.vsupa.client.invoice;

import java.io.Serializable;

/**
 * @author Maxwell.Lee
 * @date 2018-01-18 13:25
 * @since   1.0.0
 */
public class InvoiceInspectionRequest implements Serializable {
    private static final long serialVersionUID = -3162769567669269908L;

    /**
     * 发票代码，（必要）；
     */
    private String      invoiceCode;

    /**
     * 发票号码，（必要）；
     */
    private String      invoiceNo;

    /**
     * 开票日期：YYYY-MM-DD，（必要）；
     */
    private String      billingDate;

    /**
     * 校验码后6位（普票、电子普票、卷式普票必填）；
     */
    private String      verifyCode;

    /**
     * 合计金额（不含税），必须精确到两位小数（专票、货运专票、机动车专票必填）；
     */
    private Double      amountWithoutTax;

    public InvoiceInspectionRequest() {

    }

    public InvoiceInspectionRequest(String code, String no, String date, String verifyCode, Double amount) {
        this.invoiceCode = code;
        this.invoiceNo = no;
        this.billingDate = date;
        this.verifyCode = verifyCode;
        this.amountWithoutTax = amount;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Double getAmountWithoutTax() {
        return amountWithoutTax;
    }

    public void setAmountWithoutTax(Double amountWithoutTax) {
        this.amountWithoutTax = amountWithoutTax;
    }

    @Override
    public String toString() {
        return "InvoiceInspectionRequest{" +
                "invoiceCode='" + invoiceCode + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", billingDate='" + billingDate + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", amountWithoutTax=" + amountWithoutTax +
                '}';
    }
}
