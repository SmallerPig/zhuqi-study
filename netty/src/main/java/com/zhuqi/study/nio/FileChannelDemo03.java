package com.zhuqi.study.nio;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuqi at 2021/11/20
 * <p>
 * 拷贝文件内容
 * 1.txt=>inputstream/nio filechannel=> byteBuffer => filechannel/outputStrem=>02.txt
 */
public class FileChannelDemo03 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./netty/1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("./netty/02.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            // 如果没有下面这行，当position=limit 时就不会读取到数据，read也就不会有-1的机会
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);

            if (read == -1) {
                break;
            }
            // put buffer's value to filechannel02
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        fileInputStream.close();
        fileOutputStream.close();

    }
}
