package com.vsupa.client.sms;

import java.io.Serializable;

/**
 * 短信下发结果
 * @author Maxwell.Lee
 * @date 2018-02-05 11:58
 * @since   1.0.0
 */
public class SMSDeliveryResult implements Serializable {

    private static final long serialVersionUID = -1525763034842926431L;

    private int         flag;

    private String      message;

    private String      debugMessage;

    public SMSDeliveryResult(int flag, String message, String debugMessage) {
        this.flag = flag;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public int getFlag() {
        return flag;
    }

    public String getMessage() {
        return message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public boolean isSuccess() {
        return (flag == 0);
    }

    @Override
    public String toString() {
        return "SMSDeliveryResult{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                '}';
    }
}
