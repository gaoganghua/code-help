package com.code.help.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * date:17/11/2018
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 通过文件的路径得到文件对象
     *
     * @param path
     * @param defaultPath
     * @return
     * @throws IOException
     */
    public static File getFileByName(String path, String defaultPath) throws IOException {
        File file = null;
//        System.out.println(System.getProperty("user.dir"));//获取项目目录
        String dirPath = ResourceUtils.getURL("classpath:").getPath();

        if (StringUtils.isEmpty(path)) {
            file = new File(dirPath + "/" + defaultPath);
        } else {
            file = new File(dirPath + "/" + path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        }

        return file;
    }

    public static File getFileByNameNew(String path, String defaultPath) throws IOException {
        File file = null;
        if (StringUtils.isEmpty(path)) {
            file = new File(defaultPath);
        }
        if (file.isDirectory()) {
            return file;
        } else {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
        }

        return file;
    }

    public static File getFileByDirAndName(String dir, String path) throws IOException {
        if (StringUtils.isEmpty(dir) || StringUtils.isEmpty(path)) {
            logger.error("dir or path is null {}, {}", dir, path);
            return null;
        }

        File file = new File(dir, path);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

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

    public static void writeFileByBuffer() {

    }
}
