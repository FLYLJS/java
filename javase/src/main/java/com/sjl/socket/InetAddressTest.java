package com.sjl.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Administrator
 * InetAddress类
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress实例
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("计算机名-->"+address.getHostName());
        System.out.println("IP地址-->" + address.getHostAddress());

        //获取字节数组形式的IP
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP地址-->"+ Arrays.toString(bytes));
        System.out.println("InetAddress-->" + address);

        //根据名称来获取InetAddress实例
//        InetAddress name = InetAddress.getByName("PC-20200613FNHY");
//        System.out.println(name);

        //根据IP地址获取实例
        InetAddress name = InetAddress.getByName("192.168.0.105");
        System.out.println(name);
    }
}
