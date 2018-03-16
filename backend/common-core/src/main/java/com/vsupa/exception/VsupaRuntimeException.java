package com.vsupa.exception;

/**
 * @author Maxwell.Lee
 * @date 2018-01-15 13:57
 * @since   1.0.0
 */
public class VsupaRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 2045382638749454518L;

    private String      errorCode;

    private String      errorMessage;

    private String      debugMessage;

    public VsupaRuntimeException(String errorCode, String errorMessage) {
        super(String.format("%s[%s]", errorMessage, errorCode));
    }

    public VsupaRuntimeException(String errorCode, String errorMessage, Throwable t) {
        super(String.format("%s[%s]", errorMessage, errorCode), t);
    }

    public VsupaRuntimeException(String errorCode, String errorMessage, String debugMessage) {
        super(String.format("%s[%s]", errorMessage, errorCode));
        this.debugMessage = debugMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public String toJson() {
        return String.format("{ \"errorCode\": \"%s\", \"errorMessage\":\"%s\", \"debugMessage\": \"%s\" }",
                            errorCode != null ? errorCode : "", errorMessage != null ? errorMessage : "",
                            debugMessage != null ? debugMessage : "");
    }
}
