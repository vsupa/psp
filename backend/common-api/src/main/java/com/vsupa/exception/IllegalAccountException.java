package com.vsupa.exception;

/**
 * 错误的用户账号异常；
 *
 * @author Maxwell.Lee
 * @date 2018-01-17 10:42
 * @since   1.0.0
 */
public class IllegalAccountException extends VsupaRuntimeException {

    public IllegalAccountException(String errorCode, Long accountIdInParam, Long accountInSession) {
        super(errorCode, String.format("请求的数据不归属当前登录的账号"),
                String.format("ReqAccount=%d,LoginAccount=%d", accountIdInParam, accountInSession));
    }

}
