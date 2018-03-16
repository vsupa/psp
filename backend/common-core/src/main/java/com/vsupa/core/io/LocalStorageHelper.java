package com.vsupa.core.io;

import java.io.File;

/**
 * 本地文件存储Helper
 * @author Maxwell.Lee
 * @date 2018-01-10 20:52
 * @since   1.0.0
 */
public class LocalStorageHelper {

    public static LocalStorageHelper    getInstance() {
        return new LocalStorageHelper();
    }

    public File     ensureTmpFileSavePath(String namespace, String fileName, String extName) {
        File dir = new File("D:/var/tmp", namespace);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return new File(dir, String.format("%s.%s", fileName, extName));
    }

}
