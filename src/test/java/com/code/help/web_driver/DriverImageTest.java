package com.code.help.web_driver;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class DriverImageTest {
    @Test
    public void test() throws Exception {
//        testImageIo();


    }
    public void testImageIo() throws IOException {
        BufferedImage image = ImageIO.read(new File("/Users/chancelee/Desktop/DEFAULT/test/aa.jpg"));


        int height = image.getHeight()/2;
        int width = image.getWidth()/2;
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                image.setRGB(i, j, Color.BLACK.getRGB());
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(image, "jpg", baos);
        System.out.println(Base64.getEncoder().encodeToString(baos.toByteArray()));


        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/chancelee/Desktop/DEFAULT/test/aa1.jpg"));
        bos.write(baos.toByteArray());
        bos.flush();
        bos.close();

    }
}
