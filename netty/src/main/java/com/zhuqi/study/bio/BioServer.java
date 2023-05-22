package com.zhuqi.study.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhuqi at 2021/11/20
 */
public class BioServer {
    /*
    1. 服务端启动一个serverSocket
    2. 客户端启动socket对服务器进行通信，默认情况下服务器端需要对每个客户简历一个线程进行通信
    3. 咨询是否有线程响应，如果没有则会等待或者拒绝
    4.com.zhuqi.study.bio.BioServer
     */

    public static void main(String[] args) throws IOException {
        System.out.println("main start");

        // 1.创建线程池
        // 2. 有客户端进行连接时，创建一个线程，与之通信

        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("server start");

        while (true) {
            String name = Thread.currentThread().getName();
            System.out.println("name = " + name);
            final Socket socket = serverSocket.accept();
            System.out.println("get a client -!");

            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 可以和客户端通讯的
                    handler(socket);
                }
            });
        }

    }


    //编写一个handler 方法，与客户端进行通讯
    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        long id = Thread.currentThread().getId();
        System.out.println(" ThreadId = " + id);
        String name = Thread.currentThread().getName();
        System.out.println("ThreadName = " + name);
        // get input stream by socket
        try {
            InputStream inputStream = socket.getInputStream();
            //循环读取客户端发送的数据
            while (true) {
                System.out.println("ThreadName = " + name);

                int read = inputStream.read(bytes);
                if (read != -1) {
                    // print the content come from client
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("close socket connect");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
