package com.vsupa.client.obs;

/**
 * 对象存储服务配置
 * @author Maxwell.Lee
 * @date 2018-01-12 17:19
 * @since   1.0.0
 */
public class ObjectStorageServiceConfig {

    /**
     * socket的超时时间，单位：毫秒
     */
    private int connectionTimeout;

    /**
     * 业务请求的最大连接数
     */
    private int maxConnections;

    /**
     * 业务请求失败的最大重试次数
     */
    private int maxErrorRetry;

    /**
     * 桶名称，（必要）；
     */
    private String  bucket;

    /**
     * AccessKey，（必要）；
     */
    private String  accessKey;

    /**
     * SecretKey，（必要);
     */
    private String  secretKey;

    /**
     * EndPoint，（必要）；
     */
    private String  endPoint;

    /**
     * 对外暴露的域名，（必要）；
     */
    private String  exportDomain;

    public ObjectStorageServiceConfig() {
        this.connectionTimeout = 20000;
        this.maxConnections = 20;
        this.maxErrorRetry = 5;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMaxErrorRetry() {
        return maxErrorRetry;
    }

    public void setMaxErrorRetry(int maxErrorRetry) {
        this.maxErrorRetry = maxErrorRetry;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getExportDomain() {
        return exportDomain;
    }

    public void setExportDomain(String exportDomain) {
        this.exportDomain = exportDomain;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjectStorageServiceConfig{");
        sb.append("connectionTimeout=").append(connectionTimeout);
        sb.append(", maxConnections=").append(maxConnections);
        sb.append(", maxErrorRetry=").append(maxErrorRetry);
        sb.append(", bucket='").append(bucket).append('\'');
        sb.append(", accessKey='").append(accessKey).append('\'');
        sb.append(", secretKey='").append(secretKey).append('\'');
        sb.append(", endPoint='").append(endPoint).append('\'');
        sb.append(", exportDomain='").append(exportDomain).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
