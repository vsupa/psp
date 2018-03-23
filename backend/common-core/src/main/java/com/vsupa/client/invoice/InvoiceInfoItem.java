package com.vsupa.client.invoice;

import java.io.Serializable;

/**
 * 发票开票项目，如：商品、劳务等收费项目；
 *
 * @author Maxwell.Lee
 * @date 2018-01-18 11:51
 * @since   1.0.0
 */
public class InvoiceInfoItem implements Serializable {

    private static final long serialVersionUID = -5739318917622750193L;

    /**
     * 明细行号；
     */
    private Integer  rowNo;

    /**
     * 商品编码；
     */
    private String  commodityCode;

    /**
     * 商品名称；
     */
    private String  commodityName;

    /**
     * 商品个数或数量；
     */
    private String  quantity;

    /**
     * 商品单价，单位：元；
     */
    private String  unitPrice;

    /**
     * 不含税金额，单位：分；
     */
    private Long    amount;

    /**
     * 商品型号或商品规格；
     */
    private String  specificationModel;

    /**
     * 商品单位；
     */
    private String unit;

    /**
     * 税率，单位：万分之一；
     */
    private Integer taxRate;

    /**
     * 税额，单位：分；
     */
    private Long tax;

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSpecificationModel() {
        return specificationModel;
    }

    public void setSpecificationModel(String specificationModel) {
        this.specificationModel = specificationModel;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public Long getTax() {
        return tax;
    }

    public void setTax(Long tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "InvoiceInfoItem{" +
                "rowNo=" + rowNo +
                ", commodityCode='" + commodityCode + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", amount=" + amount +
                ", specificationModel='" + specificationModel + '\'' +
                ", unit='" + unit + '\'' +
                ", taxRate=" + taxRate +
                ", tax=" + tax +
                '}';
    }
}
