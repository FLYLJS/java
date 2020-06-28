package com.sjl.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author Administrator
 * <p>
 * 客户端
 */
public class Client {

    private static OutputStream outputStream;
    private static PrintWriter printWriter;
    private static InputStream inputStream;
    private static BufferedReader bufferedReader;

    public static void main(String[] args) {

        try {
            //创建客户端Socket
            Socket socket = new Socket("127.0.0.1", 8888);
            //输出流，用来向服务器发送信息
            outputStream = socket.getOutputStream();
            //包装为打印流
            printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：tom;密码：234");
            printWriter.flush();
            //关闭输出流
            socket.shutdownOutput();

            //输入流，读取服务器端的响应信息
            inputStream = socket.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String info;
            while ((info = bufferedReader.readLine()) != null){
                System.out.println("【我是客户端，服务器说】"+info);
            }
            //关闭资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
