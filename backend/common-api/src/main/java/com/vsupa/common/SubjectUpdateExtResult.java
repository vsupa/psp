package com.vsupa.common;

/**
 * 目标更新结果（带更新后的数据）
 * @author Maxwell.Lee
 * @date 2018-03-12 19:09
 * @since   1.0.0
 */
public class SubjectUpdateExtResult<T> extends SubjectUpdateResult {

    private T   data;

    public SubjectUpdateExtResult(boolean isSuccess, String reason) {
        super(isSuccess, reason);
    }

    public SubjectUpdateExtResult(int affectedRow, T data) {
        super(affectedRow);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SubjectUpdateExtResult{" +
                "data=" + data +
                "} " + super.toString();
    }
}
