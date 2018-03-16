package com.vsupa.common;

import java.io.Serializable;

/**
 * 通用的结果表示VO
 * @author  Maxwell.Lee
 * @date 2018-01-04 11:58
 * @since 1.0.0
 */
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -5417642374443113946L;

    /**
     * 结果标识符：0表示成功，小于0接口调用失败标识，大于0表示业务逻辑错误；
     */
    private int         flag;

    /**
     * 内部错误编码，根据该编码可以定位出错的情况；
     */
    private String      errorCode;

    /**
     * 错误提示信息；
     */
    private String      message;

    /**
     * 用于查错的提示信息，不能显示给用户；
     */
    private String      debugMessage;

    /**
     * 结果数据；
     */
    private T           data;

    protected ResultVo(int flag, String errorCode, String message, String debugMessage) {
        this.flag = flag;
        this.errorCode = errorCode;
        this.message = message;
        this.debugMessage = debugMessage;
    }

    protected ResultVo(T data) {
        this.flag = 0;
        this.data = data;
    }

    public static <T> ResultVo<T> ofSuccess(T data) {
        return new ResultVo<>(data);
    }

    public static <T> ResultVo<T> ofFail(int flag, String errorCode, String message, String debugMessage) {
        return new ResultVo<>(flag, errorCode, message, debugMessage);
    }

    public static <T> ResultVo<T> ofIllegalArgument(String errorCode, String debugMessage) {
        return new ResultVo<>(-1, errorCode, "资料没有填全。", debugMessage);
    }

    public static <T> ResultVo<T> failOfNotImplement(String errorCode, String message) {
        return new ResultVo<>(-999, errorCode, message, null);
    }

    public static <T> ResultVo<T> failOfUpdateSubject(String errorCode, SubjectUpdateResult rst) {
        return new ResultVo<>(1, errorCode, rst.getReason(), String.format("affectCount=%d", rst.getAffectedCount()));
    }

    public static <T> ResultVo<T> failOfRemoveSubject(String errorCode, SubjectRemoveResult rst) {
        return new ResultVo<>(1, errorCode, rst.getReason(), String.format("affectCount=%d", rst.getAffectedCount()));
    }

    public static <T> ResultVo<T> failOfCommitSubject(String errorCode, SubjectConfirmResult<?> rst) {
        if (rst == null) {
            return new ResultVo<>(1, errorCode, "接口调用失败。", "接口返回空值。");
        } else {
            return new ResultVo<>(1, errorCode, rst.getReason(), null);
        }
    }

    public static <T> ResultVo<T> failOfCancelSubject(String errorCode, SubjectCancelResult rst) {
        if (rst == null) {
            return new ResultVo<>(1, errorCode, "接口调用失败。", "接口返回空值。");
        } else {
            return new ResultVo<>(1, errorCode, rst.getReason(), String.format("affectCount=%d", rst.getFlag()));
        }
    }

    /**
     * 参数不全或参数取值错误；
     * @param errorCode     错误编码，便于查错，（必要);
     * @param args          错误的参数，（必要）；
     */
    public static <T> ResultVo<T> failOfIllegalArgument(String errorCode, String args) {
        return new ResultVo<>(-1001, errorCode, "参数不全：" + args, null);
    }

    /**
     * 请求是否成功
     * @return  如果成功，返回true；
     */
    public boolean isSuccess() {
        return (flag == 0);
    }

    /**
     * 结果标识
     * @return  0表示成功，小于0接口调用失败标识，大于0表示业务逻辑错误；
     */
    public int getFlag() {
        return flag;
    }

    /**
     * 错误编码
     * @return  0x00开头表示系统级错误，其他为API各自定义；
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 附加信息
     * @return  附加信息，比较正规的；一般用于记录错误提示信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 查错信息
     * @return  查错信息
     */
    public String getDebugMessage() {
        return debugMessage;
    }

    /**
     * API请求结果数据
     * @return  API请求结果数据
     */
    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "flag=" + flag +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
