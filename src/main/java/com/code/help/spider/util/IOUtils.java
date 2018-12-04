package com.code.help.spider.util;

import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    public static String parseStream(InputStream stream) throws IOException {
        StringBuffer result = new StringBuffer();
        byte[] bytes = new byte[1024];
        int n = 0;
        while ((n = stream.read(bytes)) != -1) {
            String str = new String(bytes, 0, n);
            result.append(str);
        }

        return result.toString();
    }
}
