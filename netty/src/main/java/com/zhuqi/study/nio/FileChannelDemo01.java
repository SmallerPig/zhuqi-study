package com.zhuqi.study.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author zhuqi at 2021/11/20
 * channel 往文件里写东西
 */
public class FileChannelDemo01 {

    public static void main(String[] args) throws IOException {
        String s = "hello zhuqi";
        // create a inputstrem->channel
        FileOutputStream fileOutputStream = new FileOutputStream("./netty/file01.txt");
        // get channel by fileoutputStream
        FileChannel fileChannel = fileOutputStream.getChannel();

        // create buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // put stream into buffer
        byteBuffer.put(s.getBytes(StandardCharsets.UTF_8));

        // change position
        byteBuffer.flip();

        // put the value of bytebuffer into fileChannel
        fileChannel.write(byteBuffer);

        fileOutputStream.close();


    }

}
