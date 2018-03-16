package com.vsupa.common;

import java.io.Serializable;

/**
 * 目标取消结果；
 * @author Maxwell.Lee
 * @date 2018-03-13 10:14
 * @since   1.0.0
 */
public class SubjectCancelResult implements Serializable {

    private static final long serialVersionUID = -1970263817696830862L;

    /**
     * 受影响实体个数；
     */
    private int         flag;

    /**
     * 是否成功；
     */
    private boolean     success;

    /**
     * 原因描述；
     */
    private String      reason;

    public SubjectCancelResult(boolean isSuccess, String reason) {
        this.success = isSuccess;
        this.reason = reason;
    }

    public SubjectCancelResult(int flag) {
        this.flag = flag;
        if (flag > 0) {
            this.success = true;
            this.reason = String.format("目标已经更新，flag=%d", flag);
        } else if (flag == 0) {
            this.success = false;
            this.reason = String.format("目标没有找到，flag=%d", flag);
        } else {
            this.success = false;
            this.reason = String.format("不执行更新目标，flag=%d", flag);
        }
    }

    public int getFlag() {
        return flag;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "SubjectCancelResult{" +
                "flag=" + flag +
                ", success=" + success +
                ", reason='" + reason + '\'' +
                '}';
    }
}
