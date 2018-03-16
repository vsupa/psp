package com.vsupa.invast.client.invoice;

import java.io.Serializable;
import java.util.List;

/**
 * 发票信息
 * @author Maxwell.Lee
 * @date 2018-01-18 11:49
 * @since   1.0.0
 */
public class InvoiceInfo implements Serializable {

    private static final long serialVersionUID = -1282415696045804758L;

    /**
     * 发票分类
     */
    private String      category;

//    /**
//     * 发票类型
//     */
//    private String      invoiceType;

    /**
     * 地区
     */
    private String      area;

    /**
     * 真伪结果
     */
    private String      clarifyResult;

    /**
     * 发票代码
     */
    private String      invoiceCode;

    /**
     * 发票号码
     */
    private String      invoiceNo;

    /**
     * 原始的发票编码
     */
    private String      originalCode;

    /**
     * 原始的发票号码
     */
    private String      originalNo;

    /**
     * 开票日期：YYYY-MM-DD
     */
    private String      billingDate;

    /**
     * 所属行政区编码
     */
    private String      administrativeDivisionNo;

    /**
     * 所属行政区名称
     */
    private String      administrativeDivisionName;

    /**
     * 主管税务机关
     */
    private String      taxAuthorityNo;

    /**
     * 主管税务名称
     */
    private String      taxAuthorityName;

    /**
     * 购方名称
     */
    private String      purchaserName;

    /**
     * 购方税号
     */
    private String      purchaserTaxNo;

    /**
     * 购方开户银行及其账户
     */
    private String      purchaserBankAndAccount;

    /**
     * 购方地址电话
     */
    private String      purchaserAddressPhone;

    /**
     * 销方名称
     */
    private String      salesName;

    /**
     * 销方税号
     */
    private String      salesTaxNo;

    /**
     * 销方地址电话
     */
    private String      salesAddressPhone;

    /**
     * 销方开户银行及其账户
     */
    private String      salesBankAndAccount;

    /**
     * 合计金额（商品），单位：分；
     */
    private Long        totalAmount;

    /**
     * 合计税额，单位：分；
     */
    private Long        totalTax;

    /**
     * 合计税额（中文大写），单位：元；
     */
    private String          totalTaxCn;

    /**
     * 	价税合计， 单位：分；
     */
    private Long          amountWithTax;

    /**
     * 价税合计（中文大写），单位：元；
     */
    private String          amountWithTaxCn;

    /**
     * 税率，单位：万分之一；
     */
    private Integer         taxRate;

    /**
     * 备注
     */
    private String          remarks;

    /**
     * 机器编码或税控盘号
     */
    private String          machineCode;

    /**
     * 校验码
     */
    private String          verifyCode;

    /**
     * 发票状态，包括：蓝票、作废、红票和冲红；
     */
    private String          state;

    /**
     * 承运人名称
     */
    private String          carrierName;

    /**
     * 承运人识别号
     */
    private String          carrierTaxNo;

    /**
     * 受票方名称
     */
    private String          draweeName;

    /**
     * 受票方识别号
     */
    private String          draweeTaxNo;

    /**
     * 运输货物信息
     */
    private String          cargoInformation;

    /**
     * 起运地、经由、到达地
     */
    private String          transportRoute;

    /**
     * 身份证号码/组织机构代码
     */
    private String          idCardNo;

    /**
     * 车辆类型
     */
    private String          vehicleType;

    /**
     * 厂牌型号
     */
    private String          brandModel;

    /**
     * 产地
     */
    private String          originPlace;

    /**
     * 合格证号
     */
    private String          certificateNo;

    /**
     * 商检单号
     */
    private String          inspectionListNo;

    /**
     * 发动机号
     */
    private String          engineNo;

    /**
     * 车辆识别代号/车架号码
     */
    private String          vehicleNo;

    /**
     * 进口证明书号
     */
    private String          importCertificateNo;

    /**
     * 完税凭证号码
     */
    private String          paymentVoucherNo;

    /**
     * 车船吨位
     */
    private String          tonnage;

    /**
     * 限乘人数
     */
    private String          passengersLimited;

    /**
     *
     */
    private String          receivingClerk;

    /**
     * 发票详细信息列表
     */
    private List<InvoiceInfoItem> invoiceList;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getClarifyResult() {
        return clarifyResult;
    }

    public void setClarifyResult(String clarifyResult) {
        this.clarifyResult = clarifyResult;
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

    public String getOriginalCode() {
        return originalCode;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    public String getOriginalNo() {
        return originalNo;
    }

    public void setOriginalNo(String originalNo) {
        this.originalNo = originalNo;
    }

    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public String getAdministrativeDivisionNo() {
        return administrativeDivisionNo;
    }

    public void setAdministrativeDivisionNo(String administrativeDivisionNo) {
        this.administrativeDivisionNo = administrativeDivisionNo;
    }

    public String getAdministrativeDivisionName() {
        return administrativeDivisionName;
    }

    public void setAdministrativeDivisionName(String administrativeDivisionName) {
        this.administrativeDivisionName = administrativeDivisionName;
    }

    public String getTaxAuthorityNo() {
        return taxAuthorityNo;
    }

    public void setTaxAuthorityNo(String taxAuthorityNo) {
        this.taxAuthorityNo = taxAuthorityNo;
    }

    public String getTaxAuthorityName() {
        return taxAuthorityName;
    }

    public void setTaxAuthorityName(String taxAuthorityName) {
        this.taxAuthorityName = taxAuthorityName;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getPurchaserTaxNo() {
        return purchaserTaxNo;
    }

    public void setPurchaserTaxNo(String purchaserTaxNo) {
        this.purchaserTaxNo = purchaserTaxNo;
    }

    public String getPurchaserBankAndAccount() {
        return purchaserBankAndAccount;
    }

    public void setPurchaserBankAndAccount(String purchaserBankAndAccount) {
        this.purchaserBankAndAccount = purchaserBankAndAccount;
    }

    public String getPurchaserAddressPhone() {
        return purchaserAddressPhone;
    }

    public void setPurchaserAddressPhone(String purchaserAddressPhone) {
        this.purchaserAddressPhone = purchaserAddressPhone;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public String getSalesTaxNo() {
        return salesTaxNo;
    }

    public void setSalesTaxNo(String salesTaxNo) {
        this.salesTaxNo = salesTaxNo;
    }

    public String getSalesAddressPhone() {
        return salesAddressPhone;
    }

    public void setSalesAddressPhone(String salesAddressPhone) {
        this.salesAddressPhone = salesAddressPhone;
    }

    public String getSalesBankAndAccount() {
        return salesBankAndAccount;
    }

    public void setSalesBankAndAccount(String salesBankAndAccount) {
        this.salesBankAndAccount = salesBankAndAccount;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Long totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalTaxCn() {
        return totalTaxCn;
    }

    public void setTotalTaxCn(String totalTaxCn) {
        this.totalTaxCn = totalTaxCn;
    }

    public Long getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(Long amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public String getAmountWithTaxCn() {
        return amountWithTaxCn;
    }

    public void setAmountWithTaxCn(String amountWithTaxCn) {
        this.amountWithTaxCn = amountWithTaxCn;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierTaxNo() {
        return carrierTaxNo;
    }

    public void setCarrierTaxNo(String carrierTaxNo) {
        this.carrierTaxNo = carrierTaxNo;
    }

    public String getDraweeName() {
        return draweeName;
    }

    public void setDraweeName(String draweeName) {
        this.draweeName = draweeName;
    }

    public String getDraweeTaxNo() {
        return draweeTaxNo;
    }

    public void setDraweeTaxNo(String draweeTaxNo) {
        this.draweeTaxNo = draweeTaxNo;
    }

    public String getCargoInformation() {
        return cargoInformation;
    }

    public void setCargoInformation(String cargoInformation) {
        this.cargoInformation = cargoInformation;
    }

    public String getTransportRoute() {
        return transportRoute;
    }

    public void setTransportRoute(String transportRoute) {
        this.transportRoute = transportRoute;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getInspectionListNo() {
        return inspectionListNo;
    }

    public void setInspectionListNo(String inspectionListNo) {
        this.inspectionListNo = inspectionListNo;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getImportCertificateNo() {
        return importCertificateNo;
    }

    public void setImportCertificateNo(String importCertificateNo) {
        this.importCertificateNo = importCertificateNo;
    }

    public String getPaymentVoucherNo() {
        return paymentVoucherNo;
    }

    public void setPaymentVoucherNo(String paymentVoucherNo) {
        this.paymentVoucherNo = paymentVoucherNo;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    public String getPassengersLimited() {
        return passengersLimited;
    }

    public void setPassengersLimited(String passengersLimited) {
        this.passengersLimited = passengersLimited;
    }

    public String getReceivingClerk() {
        return receivingClerk;
    }

    public void setReceivingClerk(String receivingClerk) {
        this.receivingClerk = receivingClerk;
    }

    public List<InvoiceInfoItem> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<InvoiceInfoItem> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @Override
    public String toString() {
        return "InvoiceInfo{" +
                "category='" + category + '\'' +
                ", area='" + area + '\'' +
                ", clarifyResult='" + clarifyResult + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", originalCode='" + originalCode + '\'' +
                ", originalNo='" + originalNo + '\'' +
                ", billingDate='" + billingDate + '\'' +
                ", administrativeDivisionNo='" + administrativeDivisionNo + '\'' +
                ", administrativeDivisionName='" + administrativeDivisionName + '\'' +
                ", taxAuthorityNo='" + taxAuthorityNo + '\'' +
                ", taxAuthorityName='" + taxAuthorityName + '\'' +
                ", purchaserName='" + purchaserName + '\'' +
                ", purchaserTaxNo='" + purchaserTaxNo + '\'' +
                ", purchaserBankAndAccount='" + purchaserBankAndAccount + '\'' +
                ", purchaserAddressPhone='" + purchaserAddressPhone + '\'' +
                ", salesName='" + salesName + '\'' +
                ", salesTaxNo='" + salesTaxNo + '\'' +
                ", salesAddressPhone='" + salesAddressPhone + '\'' +
                ", salesBankAndAccount='" + salesBankAndAccount + '\'' +
                ", totalAmount=" + totalAmount +
                ", totalTax=" + totalTax +
                ", totalTaxCn='" + totalTaxCn + '\'' +
                ", amountWithTax=" + amountWithTax +
                ", amountWithTaxCn='" + amountWithTaxCn + '\'' +
                ", taxRate=" + taxRate +
                ", remarks='" + remarks + '\'' +
                ", machineCode='" + machineCode + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                ", state='" + state + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", carrierTaxNo='" + carrierTaxNo + '\'' +
                ", draweeName='" + draweeName + '\'' +
                ", draweeTaxNo='" + draweeTaxNo + '\'' +
                ", cargoInformation='" + cargoInformation + '\'' +
                ", transportRoute='" + transportRoute + '\'' +
                ", idCardNo='" + idCardNo + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", brandModel='" + brandModel + '\'' +
                ", originPlace='" + originPlace + '\'' +
                ", certificateNo='" + certificateNo + '\'' +
                ", inspectionListNo='" + inspectionListNo + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", importCertificateNo='" + importCertificateNo + '\'' +
                ", paymentVoucherNo='" + paymentVoucherNo + '\'' +
                ", tonnage='" + tonnage + '\'' +
                ", passengersLimited='" + passengersLimited + '\'' +
                ", receivingClerk='" + receivingClerk + '\'' +
                ", invoiceList=" + invoiceList +
                '}';
    }
}
