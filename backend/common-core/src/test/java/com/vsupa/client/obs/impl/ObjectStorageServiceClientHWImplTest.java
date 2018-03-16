package com.vsupa.client.obs.impl;


import com.vsupa.client.obs.ObjectStorageServiceClient;
import com.vsupa.client.obs.ObjectStorageServiceConfig;
import com.vsupa.client.obs.PutObjectResult;
import com.vsupa.core.mime.MimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

/**
 * @author Maxwell.Lee
 * @date 2018-01-12 17:39
 * @since   1.0.0
 */
public class ObjectStorageServiceClientHWImplTest {

    private static final ObjectStorageServiceConfig conf = new ObjectStorageServiceConfig();

    static {
        conf.setBucket("invast-dev-oss");
        conf.setAccessKey("FN3CWDGHX1LKUGIQX0FO");
        conf.setSecretKey("zhsv3a2BbDfjVDjrYUmp5ayngZq75g7JdH2PTWyC");
        conf.setEndPoint("obs.cn-south-1.myhwclouds.com");
        conf.setExportDomain("invast-dev-oss.obs.cn-south-1.myhwclouds.com");
    }

    private ObjectStorageServiceClient client = new ObjectStorageServiceClientHWImpl(conf);

    @Test
    public void getExposeUrl() {
        System.out.println(client.getExposeUrl("test/vsupa_logo_001.jpg"));
        System.out.println(client.getExposeUrl("test/vsupa_logo_001.png"));
    }

    @Test
    public void createPutFileSignedUrl() {
        String url;
        Date expireDate = new Date(System.currentTimeMillis() + 3600000);
        String  key = "test/vsupa_logo_001.jpg";

        url = client.createPutFileSignedUrl(key, MimeUtil.recognizeContentTypeByFileName(key), expireDate);
        Assert.assertNotNull(url);
        System.out.println(url);
    }

    @Test
    public void putObject() {
        PutObjectResult rst;

        rst = client.putObject("test/logo.png", new File("D:\\var\\tmp\\vsupa_logo.png"));

        Assert.assertNotNull(rst);
        System.out.println(rst);
    }

    @Test
    public void putObject2() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Date expireDate = new Date(System.currentTimeMillis() + 3600000L);
        String keyName = "test/vsupa_logo_003.png";
        String url = client.createPutFileSignedUrl(keyName, MimeUtil.recognizeContentTypeByFileName(keyName), expireDate);

        HttpPut req = new HttpPut(URI.create(url));
        req.setEntity(new FileEntity(new File("D:\\var\\tmp\\vsupa_logo.png"), ContentType.create("image/png")));

//        HttpPost req = new HttpPost(URI.create(url));
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody("file", new File("D:\\var\\tmp\\vsupa_logo.png"),
//                ContentType.TEXT_PLAIN, "vsupa_logo.png");
//        req.setEntity(builder.build());

        try {
            CloseableHttpResponse response = httpClient.execute(req);

            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));

            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}