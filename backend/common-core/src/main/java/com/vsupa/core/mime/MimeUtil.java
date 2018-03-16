package com.vsupa.core.mime;

/**
 * @author Maxwell.Lee
 * @date 2018-02-08 13:13
 * @since   1.0.0
 */
public class MimeUtil {

    public static String recognizeContentTypeByFileName(String fileName) {
        if (fileName == null) return null;

        if (fileName.endsWith(".png")) return "image/png";
        if (fileName.endsWith(".jpg")) return "image/jpg";
        if (fileName.endsWith(".jpeg")) return "image/jpeg";

        return null;
    }
}
