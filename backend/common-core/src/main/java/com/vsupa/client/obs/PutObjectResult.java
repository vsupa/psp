package com.vsupa.client.obs;

import java.io.Serializable;

/**
 * 上传文件结果
 * @author Maxwell.Lee
 * @date 2018-01-12 16:49
 * @since   1.0.0
 */
public class PutObjectResult implements Serializable {

    private static final long serialVersionUID = -7667732426021047010L;

    private String  bucket;

    private String  objectKey;

    private String  absUrl;

    private String  etag;

    public PutObjectResult(String bucket, String objectKey, String absUrl, String etag) {
        this.bucket = bucket;
        this.objectKey = objectKey;
        this.absUrl = absUrl;
        this.etag = etag;
    }

    public String getBucket() {
        return bucket;
    }

    public String getObjectKey() {
        return objectKey;
    }

    public String getAbsUrl() {
        return absUrl;
    }

    public String getEtag() {
        return etag;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PutObjectResult{");
        sb.append("bucket='").append(bucket).append('\'');
        sb.append(", objectKey='").append(objectKey).append('\'');
        sb.append(", absUrl='").append(absUrl).append('\'');
        sb.append(", etag='").append(etag).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
