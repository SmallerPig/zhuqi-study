package com.zhuqi.study.netty;

import sun.misc.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhuqi at 2020/11/23
 */
public class ServerSocketDemo {


    public static void main(String[] args) throws IOException {
        java.net.ServerSocket serverSocket =new java.net.ServerSocket(1080);
        Socket clientSocket = serverSocket.accept();

        BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out =  new PrintWriter(clientSocket.getOutputStream(), true);
        String requst, response;
        while ((requst = in.readLine())!= null){
            if ("Done".equals(requst)){
                break;
            }
            System.out.println("requst = " + requst);
        }


    }
}
