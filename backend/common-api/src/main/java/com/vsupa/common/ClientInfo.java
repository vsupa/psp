package com.vsupa.common;

import java.io.Serializable;

/**
 * 客户端信息Vo；
 * @author Maxwell.Lee
 * @date 2018-02-04 19:13
 * @since   1.0.0
 */
public class ClientInfo implements Serializable {
    private static final long serialVersionUID = -8534462091647330460L;

    private String      ipAddr;

    private String      userAgent;

    private String      xForwardFor;

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getxForwardFor() {
        return xForwardFor;
    }

    public void setxForwardFor(String xForwardFor) {
        this.xForwardFor = xForwardFor;
    }
}
