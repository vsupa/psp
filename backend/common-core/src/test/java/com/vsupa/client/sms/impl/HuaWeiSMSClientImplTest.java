package com.vsupa.client.sms.impl;

import com.vsupa.client.sms.SMSDeliveryResult;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Maxwell.Lee
 * @date 2018-02-05 13:44
 * @since   1.0.0
 */
public class HuaWeiSMSClientImplTest {

    private HuaWeiSMSClientImpl smsClient = new HuaWeiSMSClientImpl("vsupa", "vsupa1234",
                                "vsupa", "cn-south-1", "d3bb62a89ba24f43ae3add149239ab76");

    @Test
    public void send() {
        SMSDeliveryResult   rst;

        rst = smsClient.send("18926239285", "验证码：289345，5分钟内有效。");
        System.out.println(rst);
        Assert.assertNotNull(rst);
        Assert.assertTrue(rst.isSuccess());
    }
}