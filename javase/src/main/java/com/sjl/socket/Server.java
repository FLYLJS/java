package com.sjl.socket;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 *
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 */
public class Server {


    public static void main(String[] args) {

        try {
            //创建一个服务器端的Socket,即ServerSocket,
            //制定绑定的端口
            //并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            //记录客户端数量
            int count = 0;
            //调用accept()方法开始监听，等待客户端连接
            System.out.println("服务器即将启动，等待你的连接");
            //循环监听等待连接
            while (true){
                socket = serverSocket.accept();
                //创建一个线程
                ServerThread serverThread = new ServerThread(socket);
                //启动线程
                serverThread.start();
                //统计客户端数量
                count ++;
                System.out.println("【客户端数量】"+count);
                System.out.println("【当前客户端IP】"+socket.getInetAddress().getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
