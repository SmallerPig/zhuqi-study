package com.zhuqi.study.nio;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuqi at 2021/11/20
 * 通过channel读取文件数据
 */
public class FileChannelDemo02 {

    public static void main(String[] args) throws IOException {
        File file = new File("./netty/file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //read channel's value to buffer
        fileChannel.read(byteBuffer);

        //byte to string
        System.out.println(new String(byteBuffer.array()));

        fileInputStream.close();


    }
}
