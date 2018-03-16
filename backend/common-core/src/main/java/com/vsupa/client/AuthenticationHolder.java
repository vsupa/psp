package com.vsupa.client;

/**
 * 认证信息Holder；
 * @author Maxwell.Lee
 * @date 2018-01-18 14:15
 * @since   1.0.0
 */
public class AuthenticationHolder {

    /**
     *
     */
    private String      appKey;

    /**
     *
     */
    private String      appSecret;

    /**
     * 身份数据，类似于：username；
     */
    private String      principal;

    /**
     * 身份验证数据，类似于：password；
     */
    private String      credential;

    /**
     * 身份验证数据加密时使用的盐值；
     */
    private String      salt;

    /**
     * API服务器认证后的身份Token；
     */
    private OAuthToken  token;


    public AuthenticationHolder(String appKey, String appSecret, String principal, String credential, String salt) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.principal = principal;
        this.credential = credential;
        this.salt = salt;
    }

    /**
     * 获取AccessToken，如果手上的AccessToken过期或没有登录，调用proxy对应的方法获取；
     * @param proxy     OAuth代理；
     * @return  AccessToken
     */
    public synchronized String  getAccessToken(OAuthProxy proxy) {
        if (token != null && token.getExpireAt() > System.currentTimeMillis()) {
            return token.getAccessToken();
        }

        if (token == null) {
            OAuthToken loginRst = proxy.login(appKey, appSecret, principal, credential, salt);

            if (loginRst == null) return null;
            this.token = loginRst;
        } else {
            OAuthToken refreshRst = proxy.refresh(token.getRefreshToken());

            if (refreshRst == null) return null;
            this.token = refreshRst;
        }

        return token.getAccessToken();
    }

}
