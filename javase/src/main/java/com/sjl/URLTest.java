package com.sjl;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Administrator
 * URL常用方法
 */
public class URLTest {

    public static void main(String[] args) {
        //创建一个URL实例
        try {
            URL baidu = new URL("https://www.baidu.com");
            //?后面是参数   参数后还可以加#   #后面是锚点
            URL url = new URL(baidu, "/s?ie=utf-8&f=3&rsv_bp=1&rsv_idx=1&tn=baidu&wd=百度&fenlei=256&rsv_pq=dadffae700000a3f&rsv_t=8779862kSrSQK3%2FbOkwOeQ7MLN4NnONaRXsNBiOo3miCMwBxYKprlxNz9BM&rqlang=cn&rsv_enter=1&rsv_dl=ts_1&rsv_sug3=6&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&prefixsug=baidu&rsp=1&inputT=2984&rsv_sug4=6074");
            System.out.println("【协议】"+url.getProtocol());
            System.out.println("【主机】"+url.getHost());
            //如果未指定端口号，则使用默认的端口号，此时getPort（）方法返回-1
            System.out.println("【端口】"+url.getPort());
            System.out.println("【文件路径】"+url.getPath());
            System.out.println("【文件名称】"+url.getFile());
            //锚点
            System.out.println("【相对路径】"+url.getRef());
            System.out.println("【查询字符串】"+ url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
