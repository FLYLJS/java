package com.sjl.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Administrator
 *
 * 服务器想爱你成处理类
 */
public class ServerThread extends Thread{

    private static InputStream inputStream;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static OutputStream outputStream;
    private static PrintWriter printWriter;

    /**
     *     和本线程相关的Socket
     */
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    /**
     *     线程操作，响应客户端请求
     */
    @Override
    public void run() {
        try {
            inputStream = socket.getInputStream();
            //讲字节流包装为字符流
            inputStreamReader = new InputStreamReader(inputStream);
            //添加缓冲  提升读取速度
            bufferedReader = new BufferedReader(inputStreamReader);

            String info ;
            while ((info = bufferedReader.readLine() )!= null){
                System.out.println("【我是服务器，客户信息】"+info);
            }
            //关闭输入流
            socket.shutdownInput();
            //获取输出流，响应客户端
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("【欢迎您！】");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if(printWriter != null){
                    printWriter.close();
                }
                if(outputStream != null){
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
