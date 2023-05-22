package com.zhuqi.study.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author zhuqi at 2021/11/20
 * 使用transferFrom快速拷贝文件
 */
public class FileChannelDemo04 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./netty/01.jpg");
        FileChannel source = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("./netty/02.jpg");
        FileChannel dest = fileOutputStream.getChannel();

        dest.transferFrom(source, 0, source.size());

        dest.close();
        source.close();

        fileInputStream.close();
        fileOutputStream.close();

    }
}
