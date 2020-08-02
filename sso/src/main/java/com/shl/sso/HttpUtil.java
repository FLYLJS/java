package com.shl.sso;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;

public class HttpUtil {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(20);
        map.put("url","https://way.jd.com/he/freeweather");
        map.put("city","北京");
        map.put("appkey","2167d37cc8b7d81014984a3185ca7e0f");
        System.out.println(sendHttpRequest(map));
    }

    private static String sendHttpRequest(HashMap<String,String> map)  {
        InputStream inputStream = null;
        byte [] bytes = null;
        //定义URL
        URL url = null;
        try {
            url = new URL(map.get("url"));
            //
            //开启连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //
            //设置请求方式
            connection.setRequestMethod("POST");
            //需要输出参数
            connection.setDoOutput(true);
            //拼接参数
            StringBuilder builder = new StringBuilder();
            builder.append("city=").append(map.get("city"))
                    .append("&appkey=").append(map.get("appkey"));
            //写出参数
            connection.getOutputStream().write(builder.toString().getBytes("UTF-8"));
            //发起请求
            connection.connect();
            //接受相应的信息
            inputStream = connection.getInputStream();
            bytes = new byte[1024*8];
            inputStream.read(bytes);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new String(bytes);
    }
}
