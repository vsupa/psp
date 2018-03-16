package com.vsupa.invast.client.invoice;

import com.vsupa.invoice.VATInvoiceQRContent;

/**
 * 发票查验客户端
 *
 * @author Maxwell.Lee
 * @date 2018-01-18 11:43
 * @since   1.0.0
 */
public interface InvoiceInspectClient {

    /**
     * 根据请求参数查验发票；
     * @param request       请求参数，（必要）；
     * @return  查验结果及发票消息；
     */
    InvoiceInspectionResponse   inspect(InvoiceInspectionRequest request);

    /**
     * 根据条件查询发票的类型；
     * @param invoiceCode       条件：发票编码；
     * @return  发票类型；
     */
    InvoiceInspectionResponse   inspectCategory(String invoiceCode);

    /**
     * 根据发票二维码的内容查验发票；
     * @param qrContent     二维码内容，（必要）；
     * @return  查验结果及发票消息；
     */
    InvoiceInspectionResponse   inspectByQRCode(VATInvoiceQRContent qrContent);
}
