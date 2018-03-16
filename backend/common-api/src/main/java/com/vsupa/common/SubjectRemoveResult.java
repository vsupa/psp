package com.vsupa.common;

import java.io.Serializable;

/**
 * 目标移除结果
 * @author Maxwell.Lee
 * @date 2018-01-09 10:14
 * @since   1.0.0
 */
public class SubjectRemoveResult implements Serializable {

    private static final long serialVersionUID = 8558673559184401226L;

    private int         affectedCount;

    private boolean     success;

    private String      reason;

    public SubjectRemoveResult(boolean isSuccess, String reason) {
        this.success = isSuccess;
        this.reason = reason;
    }

    public SubjectRemoveResult(int affectedRow) {
        this.affectedCount = affectedRow;
        if (affectedRow >= 0) {
            this.success = true;
            this.reason = String.format("目标已经移除，AffectedRow=%d)", affectedRow);
        } else {
            this.success = false;
            this.reason = "不允许执行删除。";
        }
    }

    public static SubjectRemoveResult ofBatchEmpty() {
        return new SubjectRemoveResult(true, null);
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
        return "SubjectRemoveResult{" +
                "affectedCount=" + affectedCount +
                ", success=" + success +
                ", reason='" + reason + '\'' +
                '}';
    }
}
