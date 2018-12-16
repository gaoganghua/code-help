package com.code.help.spider.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    private static Logger logger = LoggerFactory.getLogger(IOUtils.class);

    public static String parseStream(InputStream stream, String charset) throws IOException {
        if (stream == null) {
            logger.info("stream is null");
            return null;
        }

        StringBuffer result = new StringBuffer();
        byte[] bytes = new byte[1024];
        int n = 0;
        while ((n = stream.read(bytes)) != -1) {
            String str = new String(bytes, 0, n, charset);
            result.append(str);
        }

        return result.toString();
    }

    public static String toJsonByFile(String filepath, String charset) throws IOException {
        if (filepath == null) {
            logger.info("filepath is null");
            return null;
        }

        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(filepath));
        StringBuffer result = new StringBuffer();
        byte[] bytes = new byte[1024];
        int n = 0;

        while ((n = stream.read(bytes)) != -1) {
            String str = new String(bytes, 0, n, charset);
            result.append(str);
        }

        stream.close();
        return result.toString();
    }
}
