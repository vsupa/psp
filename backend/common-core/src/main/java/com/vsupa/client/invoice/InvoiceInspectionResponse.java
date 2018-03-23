package com.vsupa.client.invoice;


import java.io.Serializable;

/**
 * @author Maxwell.Lee
 * @date 2018-01-18 11:47
 * @since   1.0.0
 */
public class InvoiceInspectionResponse implements Serializable {

    private static final long serialVersionUID = 1186377917887934467L;

    private boolean     success;

    private String      message;

    private String      category;

    private InvoiceInfo data;

    protected InvoiceInspectionResponse() {

    }

    public InvoiceInspectionResponse(String errorMessage) {
        this.success = false;
        this.message = errorMessage;
    }

    public InvoiceInspectionResponse(InvoiceInfo data) {
        this.success = true;
        this.data = data;
    }

    public static InvoiceInspectionResponse ofInspectCategory(String category) {
        InvoiceInspectionResponse rst = new InvoiceInspectionResponse();
        rst.success = true;
        rst.category = category;

        return rst;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public InvoiceInfo getData() {
        return data;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "InvoiceInspectionResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", category='" + category + '\'' +
                ", data=" + data +
                '}';
    }
}
