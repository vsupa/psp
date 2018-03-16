package com.vsupa.exception;

/**
 * 数据记录违反唯一性约束异常，例如：<br>
 * <li></li>
 * @author Maxwell.Lee
 * @date 2018-01-15 13:57
 * @since   1.0.0
 */
public class VsupaDataNotUniqueException extends VsupaRuntimeException {
    private static final long serialVersionUID = -7511497860258535409L;

    public VsupaDataNotUniqueException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public VsupaDataNotUniqueException(String errorCode, String errorMessage, Throwable t) {
        super(errorCode, errorMessage, t);
    }
}
