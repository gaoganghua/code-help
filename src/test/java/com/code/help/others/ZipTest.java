package com.code.help.others;

import com.code.help.util.FileUtils;
import com.code.help.util.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    @Test
    public void unzip() throws IOException {
        ZipFile zipFile = new ZipFile("/Users/chancelee/Desktop/oss/oo.zip");
        Enumeration entrys =  zipFile.entries();
        while(entrys.hasMoreElements()){
            ZipEntry entry = (ZipEntry) entrys.nextElement();
            System.out.println(new String(IOUtils.readInputStream(zipFile.getInputStream(entry))));;
        }
    }
    @Test
    public void zip() throws IOException {
        File zipFile = new File("/Users/chancelee/Desktop/oss/oo.zip");

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

        zos.putNextEntry(new ZipEntry("aa"));
        zos.write(FileUtils.readBytesByFile("/Users/chancelee/Desktop/oss/a.txt"));
        zos.putNextEntry(new ZipEntry("bb"));
        zos.write(FileUtils.readBytesByFile("/Users/chancelee/Desktop/oss/b.txt"));
        zos.putNextEntry(new ZipEntry("cc"));
        zos.write(FileUtils.readBytesByFile("/Users/chancelee/Desktop/oss/c.txt"));
        zos.close();
    }
}
