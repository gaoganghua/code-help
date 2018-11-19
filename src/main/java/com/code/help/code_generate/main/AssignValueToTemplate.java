package com.code.help.code_generate.main;

import com.code.help.code_generate.bean.TemplateBean;
import com.code.help.util.BufferUtils;
import com.code.help.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class AssignValueToTemplate {
    final static String FILENAME = "generate/template.txt";
    Logger logger = LoggerFactory.getLogger(AssignValueToTemplate.class);

    @Autowired
    private TemplateBean templateBean;

    public void assignValue() throws IOException {
        File templateFile = FileUtils.getFileByName(templateBean.getFileName(), FILENAME);
        logger.info("template file:{}", templateFile.getAbsolutePath());
        generagteByTemplate(templateFile);
    }
    private void generagteByTemplate(File file) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(templateBean.getAssignValue().size());

        for(String assignValue:templateBean.getAssignValue()){
            executorService.submit(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    logger.info(Thread.currentThread().getName()+" start, repalce #{value}->{}", assignValue);
                    FileInputStream fis = new FileInputStream(file);
                    FileChannel fileChannel = fis.getChannel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    FileOutputStream fos = new FileOutputStream(FileUtils.getFileByDirAndName(templateBean.getTargetDir(), assignValue+".txt"));
                    FileChannel outChannel = fos.getChannel();

                    while(true) {
                        int eof = fileChannel.read(byteBuffer);
                        if(eof==-1){
                            break;
                        }
                        String readStr = BufferUtils.getStringByBufferNew(byteBuffer);
                        readStr = readStr.replace("#{value}", assignValue);
                        logger.info("replace string:{}", readStr);
                        byteBuffer = BufferUtils.getBufferByString(readStr);

//                byteBuffer.flip();//已经构建了一个新的bytebuffer，所以不需要flip();
                        outChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }
                    outChannel.close();
                    fos.close();
                    fileChannel.close();
                    fis.close();
                    logger.info(Thread.currentThread().getName()+"task finish!");
                    return 1;
                }
            });

        }
        executorService.shutdown();

    }

    /**
     * @deprecated
     */
    private void oldMethod(){
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        System.out.println(Charset.defaultCharset().name());
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//            byte[] bytes = new byte[1024];
//
//            int len = 0;
//            while((len = bis.read(bytes))!=-1){
//                String s = new String(bytes, 0, len);
//                s = s.replace("#{value}", assignValue);
//                System.out.println(s);
//                bytes = s.getBytes();
//                bos.write(bytes, 0, bytes.length);
//            }
//            bos.close();
    }


}
