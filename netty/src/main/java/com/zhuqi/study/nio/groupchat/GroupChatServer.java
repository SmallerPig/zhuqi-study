package com.zhuqi.study.nio.groupchat;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * @author zhuqi at 2021/11/21
 */
public class GroupChatServer {
    private static final int PORT = 6667;
    private Selector selector;
    private ServerSocketChannel listenChannel;


}
