package com.vsupa.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 二维码图片作图工具类
 * @author Maxwell.Lee
 * @date 2018-01-10 20:34
 * @since   1.0.0
 */
public class QRImageDrawer {

    private static final Logger log = LoggerFactory.getLogger(QRImageDrawer.class);

    public static void  drawJpeg(String code, File file) {
        if (log.isDebugEnabled()) {
            log.debug("生成二维码({})图片到{}。", code, file);
        }
    }

}
