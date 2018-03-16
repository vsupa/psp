package com.vsupa.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件上传接口API参数
 *
 * @author Maxwell.Lee
 * @date 2018-01-05 10:20
 * @since 1.0.0
 */
public class FileUploadApiParamVo implements Serializable {

    private static final long serialVersionUID = 1942810459258192560L;

    /**
     * HTTP请求地址，（非空）；
     */
    private String  uploadUrl;

    /**
     * 文件访问的URL，（非空）；
     */
    private String resourceUrl;

    /**
     * 附加的HTTP Header名称，（可空）；
     */
    private String  extraHeaderName;

    /**
     * 附加的HTTP Header值，（可空）；
     */
    private String  extraHeaderValue;

    /**
     * 当前API调用参数的失效时间；
     */
    private Date     expireTime;

    /**
     * 最大文件大小，单位：字节；
     */
    private Integer     maxFileSize;

    /**
     * 应该出现在Http请求Header的Content-Type
     */
    private String      contentType;

    public FileUploadApiParamVo(String uploadUrl, String resourceUrl, String contentType,
                                Date expireTime, Integer maxFileSize) {
        this(uploadUrl, resourceUrl, contentType, expireTime, maxFileSize, null, null);
    }

    public FileUploadApiParamVo(String uploadUrl, String resourceUrl, String contentType,
                                Date expireTime, Integer maxFileSize,
                                String headerName, String headerValue) {
        this.uploadUrl = uploadUrl;
        this.resourceUrl = resourceUrl;
        this.contentType = contentType;
        this.expireTime = expireTime;
        this.maxFileSize = maxFileSize;
        this.extraHeaderName = headerName;
        this.extraHeaderValue = headerValue;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getExtraHeaderName() {
        return extraHeaderName;
    }

    public String getExtraHeaderValue() {
        return extraHeaderValue;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return "FileUploadApiParamVo{" +
                "uploadUrl='" + uploadUrl + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", extraHeaderName='" + extraHeaderName + '\'' +
                ", extraHeaderValue='" + extraHeaderValue + '\'' +
                ", expireTime=" + expireTime +
                ", maxFileSize=" + maxFileSize +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
