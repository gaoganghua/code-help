package com.code.help.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils {
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        int n;
        byte[] bus = new byte[2048];

        while ((n = inputStream.read(bus)) != -1) {
            boas.write(bus, 0, n);
        }
        return boas.toByteArray();
    }
}
