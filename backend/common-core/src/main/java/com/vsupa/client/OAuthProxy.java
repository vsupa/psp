package com.vsupa.client;

/**
 * OAuth代理；
 * @author Maxwell.Lee
 * @date 2018-01-18 15:41
 * @since   1.0.0
 */
public interface OAuthProxy {

    OAuthToken   login(String appKey, String appSecret, String principal, String credential, String salt);

    OAuthToken   refresh(String refreshToken);

}
