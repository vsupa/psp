package com.vsupa.client.sms;

/**
 * 发送短信客户端
 * @author Maxwell.Lee
 * @date 2018-02-05 11:57
 * @since   1.0.0
 */
public interface SMSClient {

    SMSDeliveryResult   send(String mobile, String content);

}
