package com.vsupa.client.obs.impl;

import com.obs.services.ObsClient;
import com.obs.services.ObsConfiguration;
import com.obs.services.model.HttpMethodEnum;
import com.vsupa.client.obs.ObjectStorageServiceClient;
import com.vsupa.client.obs.ObjectStorageServiceConfig;
import com.vsupa.client.obs.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 华为云的OBS客户端实现；
 * @author Maxwell.Lee
 * @date 2018-01-12 16:43
 * @since   1.0.0
 */
public class ObjectStorageServiceClientHWImpl implements ObjectStorageServiceClient {

    private static final Logger log = LoggerFactory.getLogger(ObjectStorageServiceClientHWImpl.class);

    private String      description;

    private ObsClient   sdkClient;

    private String      bucket;

    private String      exposeUrlTemplate;

    public ObjectStorageServiceClientHWImpl(ObjectStorageServiceConfig config) {
        if (config == null || config.getBucket() == null || config.getAccessKey() == null ||
                config.getSecretKey() == null || config.getEndPoint() == null || config.getExportDomain() == null) {
            throw new IllegalArgumentException("配置参数不全。[0x00OSSCHW3667]");
        }

        this.description = "华为云OBS客户端";
        this.bucket = config.getBucket();
        this.exposeUrlTemplate = String.format("https://%s/%%s", config.getExportDomain());

        ObsConfiguration    hwObsConf = new ObsConfiguration();
        hwObsConf.setConnectionRequestTimeout(config.getConnectionTimeout());
        hwObsConf.setMaxConnections(config.getMaxConnections());
        hwObsConf.setMaxErrorRetry(config.getMaxErrorRetry());
        hwObsConf.setHttpsOnly(true);
        hwObsConf.setEndpointHttpsPort(443);
        hwObsConf.setDisableDnsBucket(true);
        hwObsConf.setSignatString("v4");
        hwObsConf.setEndPoint(config.getEndPoint());
        //hwObsConf.setHttpProxy("127.0.0.1", 8888, null, null, null);

        this.sdkClient = new ObsClient(config.getAccessKey(), config.getSecretKey(), hwObsConf);
    }

    /**
     * 获取OSS上的文件访问URL；
     *
     * @param objectKey 文件的key，（必要）；
     * @return URL；
     */
    @Override
    public String   getExposeUrl(String objectKey) {
        return String.format(exposeUrlTemplate, objectKey);
    }

    /**
     * 创建临时上传（以PUT方式）文件的URL；
     *
     * @param objectKey     对象的Key，（必要）；
     * @param expiryTime    过期时间的Timestamp，单位：毫秒，（必要）；
     * @return 上传文件的完整URL地址；
     */
    @Override
    public String   createPutFileSignedUrl(String objectKey, String contentType, Date expiryTime) {
        if (objectKey == null || expiryTime == null) {
            throw new IllegalArgumentException("参数不全。[0x00OSSCHW5565]");
        }

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", contentType);

        return sdkClient.createSignedUrl(HttpMethodEnum.PUT, bucket, objectKey, null,
                                         expiryTime, headers, null);
    }

    /**
     * 上传本地文件到指定的Bucket下；
     *
     * @param objectKey     对象的Key，（必要）；
     * @param file          本地文件路径，（必要）；
     * @return 上传文件结果；
     */
    @Override
    public PutObjectResult putObject(String objectKey, File file) {
        if (bucket == null || objectKey == null || file == null) {
            throw new IllegalArgumentException("参数不全。[0x00OSSCHW7365]");
        }

        com.obs.services.model.PutObjectResult  rst = sdkClient.putObject(bucket, objectKey, file);
        if (rst == null) return null;

        return new PutObjectResult(bucket, objectKey, exposeUrlTemplate + objectKey, rst.getEtag());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjectStorageServiceClientHWImpl{");
        sb.append("description='").append(description).append('\'');
        sb.append(", sdkClient=").append(sdkClient);
        sb.append(", bucket='").append(bucket).append('\'');
        sb.append(", exposeUrlTemplate='").append(exposeUrlTemplate).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
