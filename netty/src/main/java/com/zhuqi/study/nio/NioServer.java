package com.zhuqi.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhuqi at 2021/11/21
 */
public class NioServer {


    public static void main(String[] args) throws IOException {

        // create a channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // get a selector
        Selector selector = Selector.open();

        // bind a port listen to
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        // config to not blocking
        serverSocketChannel.configureBlocking(false);

        // register serverSocketChannel to selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // loop while to client connect
        while (true) {
            if (selector.select(1000) == 0) { // nothing happen
                System.out.println("waiting for somthing 1 second , there's no client connected...");
                continue;
            }
            // get selectionKey lists
            // 1. something happening
            // selector.selectionKeys get event cares
            // get channel by selectionKeys
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                // get
                SelectionKey selectionKey = keyIterator.next();

                if (selectionKey.isAcceptable()) {// if op_accept , there is new client connected
                    // give client a socketChannel
                    // accept() will not block socket
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("client connected success, , socketChannel" + socketChannel.hashCode());

                    socketChannel.configureBlocking(false);

                    // register socket to selector ,
                    // and connect a Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                    System.out.println("selector.keys().size() = " + selector.keys().size());
                }
                if (selectionKey.isReadable()) { // if op_read
                    // get channel by key
                    SocketChannel channel = (SocketChannel) selectionKey.channel();

                    // get buffer which connect to channel
                    ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();

                    channel.read(buffer);
                    System.out.println("from client , the content: " + new String(buffer.array()));
                }

                // remove channel
                keyIterator.remove();

            }

        }

    }
}
