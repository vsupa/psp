package com.vsupa.common;

import java.io.Serializable;

/**
 * 目标更新结果
 * @author Maxwell.Lee
 * @date 2018-01-10 11:21
 * @since   1.0.0
 */
public class SubjectUpdateResult implements Serializable {

    private static final long serialVersionUID = 4432430820358768154L;

    private int         affectedCount;

    private boolean     success;

    private String      reason;

    public SubjectUpdateResult(boolean isSuccess, String reason) {
        this.success = isSuccess;
        this.reason = reason;
    }

    public SubjectUpdateResult(int affectedRow) {
        this.affectedCount = affectedRow;
        if (affectedRow > 0) {
            this.success = true;
            this.reason = String.format("目标已经更新，AffectedRow=%d", affectedRow);
        } else if (affectedRow == 0) {
            this.success = false;
            this.reason = String.format("目标没有找到，AffectedRow=%d", affectedRow);
        } else {
            this.success = false;
            this.reason = String.format("不执行更新目标，AffectedRow=%d", affectedRow);
        }
    }

    public int getAffectedCount() {
        return affectedCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "SubjectUpdateResult{" +
                "affectedCount=" + affectedCount +
                ", success=" + success +
                ", reason='" + reason + '\'' +
                '}';
    }
}
