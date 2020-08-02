package com.sjl.interfacetest.interfaceandcallback;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;


/**
 *
 * 接口与回调
 *
 * @author Administrator
 */
public class TimePrinter implements ActionListener {

    public static void main(String[] args) {
        TimePrinter timePrinter = new TimePrinter();
        //
        //构造一个定时器，每经过delay毫秒，通知timePrinter一次
        //
        Timer timer = new Timer(1000, timePrinter);
        //
        //定时器启动，一旦启动，就会监听actionPerformed方法
        //
        timer.start();
        //
        //没有下面这两行，不会输出
        //显示一个包含OK和一天提示消息的对话框，第一个参数为null，显示子屏幕中间
        //
        JOptionPane.showMessageDialog(null,"Quit program");
        //
        //可以输出
        //
        System.out.println("can ...");
        //
        //停止定时器
        //写在这儿只会执行一次
        //
        timer.stop();
        System.exit(0);
        //不会执行
        System.out.println("system quit ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //毫秒数
        System.out.println(e.getWhen());
        System.out.println("At the one,the time is " + Instant.ofEpochMilli(e.getWhen()));
        //getDefaultToolkit（） 获取默认的工具箱
        //beep（）   发出一声响铃
        Toolkit.getDefaultToolkit().beep();
    }
}
