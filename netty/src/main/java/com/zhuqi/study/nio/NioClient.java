package com.zhuqi.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhuqi at 2021/11/21
 */
public class NioClient {

    public static void main(String[] args) throws IOException {
        // get socketChannel
        SocketChannel socketChannel = SocketChannel.open();
        // config to no blocking
        socketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("client will not blocking , we can do something else..");
            }
        }
        String str = "hello ,zhuqi";

        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
        // send values
        // put buffer's value into channel
        socketChannel.write(buffer);
        System.in.read();


    }
}
