package com.sjl.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Administrator
 * 使用URL读取网页内容
 */
public class URLTest02 {

    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static InputStream inputStream;

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com");
            //获取url对象所表示对象的字节输入流
            inputStream = url.openStream();
            //将字节输入流转换为字符输入流
            inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            //为字符流添加缓冲
            bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            while (data != null){
                //输出数据
                System.out.println(data);
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
