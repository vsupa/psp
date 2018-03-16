package com.vsupa.client;

/**
 * 身份认证结果Token
 * @author Maxwell.Lee
 * @date 2018-01-18 14:32
 * @since   1.0.0
 */
public class OAuthToken {

    /**
     * 刷新Token；
     */
    private String      refreshToken;

    /**
     * 访问API接口用的Token；
     */
    private String      accessToken;

    /**
     * AccessToken过期时间；
     */
    private Long        expireAt;

    public OAuthToken(String refreshToken, String accessToken, Long expireAt) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
        this.expireAt = expireAt;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Long getExpireAt() {
        return expireAt;
    }

    @Override
    public String toString() {
        return "OAuthToken{" +
                "refreshToken='" + refreshToken + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", expireAt=" + expireAt +
                '}';
    }
}
