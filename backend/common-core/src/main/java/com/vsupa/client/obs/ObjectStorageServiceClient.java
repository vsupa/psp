package com.vsupa.client.obs;

import java.io.File;
import java.util.Date;

/**
 * 类S3对象存储服务客户端；
 * @author Maxwell.Lee
 * @date 2018-01-12 16:42
 * @since   1.0.0
 */
public interface ObjectStorageServiceClient {

    /**
     * 获取OSS上的文件访问URL；
     * @param objectKey     文件的key，（必要）；
     * @return  URL；
     */
    String getExposeUrl(String objectKey);

    /**
     * 创建临时上传（以PUT方式）文件的URL；
     * @param objectKey     对象的Key，（必要）；
     * @param contentType   HTTP请求的Content-Type，（必要）；
     * @param expiryTime    过期时间的Timestamp，单位：毫秒，（必要）；
     * @return  上传文件的完整URL地址；
     */
    String  createPutFileSignedUrl(String objectKey, String contentType, Date expiryTime);
    /**
     * 上传本地文件到指定的Bucket下；
     * @param objectKey     对象的Key，（必要）；
     * @param file          本地文件路径，（必要）；
     * @return  上传文件结果；
     */
    PutObjectResult putObject(String objectKey, File file);

}
