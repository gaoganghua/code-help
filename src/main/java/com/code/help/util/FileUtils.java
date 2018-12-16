package com.code.help.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;

/**
 * date:17/11/2018
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * @param path
     * @param flag
     * @return
     * @throws IOException
     */
    public static File getFileInResource(String path, boolean flag) {
        if (StringUtils.isEmpty(path)) {
            logger.info("file path is null");
            return null;
        }
//        String dirPath = ResourceUtils.getURL("classpath:").getPath();
        URL url = FileUtils.class.getClassLoader().getResource(path);
        if (url == null) {
            logger.info("file not exist");
        }
        File file = new File(url.getPath());
        if (flag) {
            try {
                newFile(file);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        return file;
    }

    public static File getFileInResource(String path, String defaultPath) throws IOException {
        if (StringUtils.isEmpty(path)) {
            path = defaultPath;
        }

        return getFileInResource(path, true);
    }

    public static File getFileInResource(String path) {
        return getFileInResource(path, false);
    }

    /**
     * @param path
     * @param defaultPath
     * @param flag
     * @return
     * @throws IOException
     */
    public static File getFileByNameNew(String path, String defaultPath, boolean flag) throws IOException {
        File file = null;
        if (StringUtils.isEmpty(path)) {
            path = defaultPath;
        }
        file = new File(path);
        if (file.isDirectory()) {
            return file;
        } else {
            if (flag) {
                newFile(file);
            }
        }

        return file;
    }

    public static File getFileByName(String path) throws IOException {
        return getFileByNameNew(path, null, false);
    }

    public static File getFileByName(String path, String defaultPath) throws IOException {
        return getFileByNameNew(path, defaultPath, false);
    }

    public static File getFileByDirAndName(String dir, String path) throws IOException {
        if (StringUtils.isEmpty(dir) || StringUtils.isEmpty(path)) {
            logger.error("dir or path is null {}, {}", dir, path);
            return null;
        }

        File file = new File(dir, path);
        newFile(file);
        return file;
    }

    public static File getFileByDirAndName(File dirFile, String path) throws IOException {
        if (dirFile == null) {
            logger.error("dir or path is null {}, {}", dirFile, path);
            return null;
        }

        File file = new File(dirFile, path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        return file;
    }

    public static void newFile(File file) throws IOException {
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    public static void writeFileByString(File file, String outStr) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(outStr.getBytes("UTF-8"));
        bos.flush();
        bos.close();
    }

    public static void main(String[] args) {
        //        System.out.println(System.getProperty("user.dir"));//获取项目目录
    }
}
