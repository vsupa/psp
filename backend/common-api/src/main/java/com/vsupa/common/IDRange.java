package com.vsupa.common;

import java.io.Serializable;

/**
 * ID范围
 * @author Maxwell.Lee
 * @date 2018-02-05 11:39
 * @since   1.0.0
 */
public class IDRange implements Serializable {
    private static final long serialVersionUID = 6709491605139417663L;

    private Long    beginId;

    private Long    endId;

    public IDRange(Long beginId, Long endId) {
        this.beginId = beginId;
        this.endId = endId;
    }

    public Long getBeginId() {
        return beginId;
    }

    public Long getEndId() {
        return endId;
    }

    @Override
    public String toString() {
        return "IDRange{" +
                "beginId=" + beginId +
                ", endId=" + endId +
                '}';
    }
}
