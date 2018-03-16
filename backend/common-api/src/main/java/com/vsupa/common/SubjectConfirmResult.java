package com.vsupa.common;

import java.io.Serializable;

/**
 * 实体提交结果；
 * @author Maxwell.Lee
 * @date 2018-03-13 13:42
 * @since   1.0.0
 */
public class SubjectConfirmResult<T> implements Serializable {
    private static final long serialVersionUID = -5301514417356829313L;

    /**
     * 提交结果数据；
     */
    private T           data;

    /**
     * 是否成功；
     */
    private boolean     success;

    /**
     * 原因描述；
     */
    private String      reason;

    public SubjectConfirmResult(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public SubjectConfirmResult(T data) {
        this.success = true;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "SubjectConfirmResult{" +
                "data=" + data +
                ", success=" + success +
                ", reason='" + reason + '\'' +
                '}';
    }
}
