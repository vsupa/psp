package com.vsupa.psp.portal.front.common;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.SSOToken;
import com.vsupa.common.ClientInfo;
import com.vsupa.exception.IllegalAccountException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Maxwell.Lee
 * @date 2018-02-01 14:56
 * @since   1.0.0
 */
public abstract class BaseController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected Long  tryGetAccountId() {
        SSOToken token = SSOHelper.attrToken(getRequest());
        if (token == null) return null;

        return token.getId();
    }

    protected Long  tryGetAccountId(HttpServletRequest request) {
        SSOToken token = SSOHelper.attrToken(request);
        if (token == null) return null;

        return token.getId();
    }

    /**
     * 确保请求的数据归属当前登录的账号：通过判断传入的userId是否与Session里的AccountId一致；
     * 如果不一致抛出指定的异常；
     *
     * @param userId        用户账号ID，（必要);
     * @param errorCode     错误编码，（必要），抛出的异常时使用的错误编码；
     * @throws IllegalAccountException
     */
    protected void ensureSameAccount(Long userId, String errorCode) throws IllegalAccountException {
        Long   aidInSession = tryGetAccountId();

        if (userId != null && aidInSession != null && userId.equals(aidInSession)) return ;

        throw new IllegalAccountException(errorCode, userId, aidInSession);
    }

    protected ClientInfo collectClientInfo() {
        return null;
    }
}
