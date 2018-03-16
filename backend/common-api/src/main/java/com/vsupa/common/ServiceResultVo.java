package com.vsupa.common;

import java.io.Serializable;

/**
 * @author Maxwell.Lee
 * @date 2018-02-05 18:50
 * @since   1.0.0
 */
public class ServiceResultVo<T> implements Serializable {
    private static final long serialVersionUID = 4331881968808694529L;

    private int         flag;

    private String      message;

    private String      debugMessage;

    private T           data;

    public ServiceResultVo(int flag, String message, String debugMessage) {
        this.flag = flag;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    public ServiceResultVo(T data) {
        this.data = data;
    }

    public int getFlag() {
        return flag;
    }

    public boolean isSuccess() {
        return (flag == 0);
    }

    public String getMessage() {
        return message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ServiceResultVo{" +
                "flag=" + flag +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
