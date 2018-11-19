package com.code.help.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

public class BufferUtils {
    /**
     * 将bytebuffer转换为string
     * @param byteBuffer
     * @return
     * @throws CharacterCodingException
     */
    public static String getStringByBufferNew(ByteBuffer byteBuffer) throws CharacterCodingException {
        if(byteBuffer==null){
            return null;
        }
        Charset charset = Charset.defaultCharset();
        if(charset==null){
            charset = Charset.forName("UTF-8");
        }
        //需要将bytebuffer重置到开始
        byteBuffer.flip();
        return charset.newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
    }

    /**
     * 将string转换为bytebuffer
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static ByteBuffer getBufferByString(String str) throws UnsupportedEncodingException {
        Charset charset = Charset.defaultCharset();
        if(charset==null){
            charset = Charset.forName("UTF-8");
        }
        return ByteBuffer.wrap(str.getBytes(charset.name()));
    }

    public static String getStringByBuffer(ByteBuffer byteBuffer, int offset, int len){
        if(byteBuffer==null){
            return null;
        }

        return new String(byteBuffer.array(), offset, len);
    }

    public static void main(String s){

    }
}
