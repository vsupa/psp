package com.vsupa.client.sms.impl;

import com.smn.client.DefaultSmnClient;
import com.smn.client.SmnClient;
import com.smn.request.sms.SmsPublishRequest;
import com.smn.response.sms.SmsPublishResponse;
import com.vsupa.client.sms.SMSClient;
import com.vsupa.client.sms.SMSDeliveryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 华为云平台短信发送客户端
 * @author Maxwell.Lee
 * @date 2018-02-05 13:10
 * @since   1.0.0
 */
public class HuaWeiSMSClientImpl implements SMSClient {

    private static final Logger log = LoggerFactory.getLogger(HuaWeiSMSClientImpl.class);

    private SmnClient   sdkClient;

    private String      signId;

    public HuaWeiSMSClientImpl(String username, String password, String domainName, String regionName, String signId) {
        this.sdkClient = new DefaultSmnClient(username, domainName, password, regionName);
        this.signId = signId;
    }

    @Override
    public SMSDeliveryResult send(String mobile, String content) {
        if (mobile == null || content == null) {
            throw new IllegalArgumentException("参数不全。[0x00HWSC3463]");
        }

        if (mobile.startsWith("999")) {
            return new SMSDeliveryResult(0, String.format("短信发送成功[%s]。", content),
                                        String.format("虚拟短信发送成功[%s]。", content));
        }
        if (mobile.startsWith("998")) {
            return new SMSDeliveryResult(-998, "短信发送失败。", "虚拟短信发送失败。");
        }

        // 构造请求对象
        SmsPublishRequest smnRequest = new SmsPublishRequest();

        // 设置参数
        smnRequest.setEndpoint("+86" + mobile)
                .setMessage(content)
                .setSignId(signId);

        // 发送短信
        try {
            SmsPublishResponse res = sdkClient.sendRequest(smnRequest);
            String debugMsg = String.format("httpCode=%d,msgId=%s, reqId=%s, errMsg=%s",
                                            res.getHttpCode(), res.getMessageId(), res.getRequestId(), res.getMessage());

            if (res.getHttpCode() == 200 || res.getHttpCode() == 201) {
                return new SMSDeliveryResult(0, null, debugMsg);
            } else {
                //TODO 根据短信平台返回的HttpCode和错误编码Code，返回平台统一的错误提示；
                return new SMSDeliveryResult(1001, "发送短信失败", debugMsg);
            }
        } catch (Exception e) {
            log.error("请求华为云短信接口异常失败：", e);

            return new SMSDeliveryResult(-999, "短信供应商接口异常", e.getMessage());
        }
    }
}
