package com.sjl.lambda;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.security.PrivilegedAction;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;


/**
 * lambd表达式
 *
 * @author Administrator
 */
public class LambdaTest{

    @Test
    public void test01() {
        /*Comparator<String> comparator = Comparator.comparingInt(String::length);*/
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter",
                "Saturn", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println(" Sorted in dictionary order");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in length");
        Arrays.sort(planets, (first, second) -> {
            return -(first.length() - second.length());
        });
        System.out.println(Arrays.toString(planets));

        var timer = new Timer(1000, event ->
                System.out.println("the time is " + LocalDate.now())
        );
        timer.start();

        JOptionPane.showMessageDialog(null, "quit program");
//        JOptionPane.showConfirmDialog(null, "are you sure");
        Toolkit.getDefaultToolkit().beep();
        System.exit(0);
    }

    /**
     * Predicate接口
     * <p>
     * 判断性接口
     */
    @Test
    public void test02() {
        java.util.List<String> list = new ArrayList<String>();
        list.add(null);
        list.add("one");
        list.add(null);
        list.add("two");
        //
        //Predicate接口  判断
        list.removeIf(e -> e == null);
        System.out.println(list.size());
    }

    /**
     * Supplier 接口
     * <p>
     * 供应性接口  懒计算
     */
    @Test
    public void test03() {
        String username = null;

        LocalDate day = null;
/*        Supplier<String> action = () ->
             Objects.requireNonNullElse(username, "");*/
        System.out.println(Objects.requireNonNullElseGet(username, () -> String.valueOf(Integer.MAX_VALUE*Math.random())));
        System.out.println(Objects.requireNonNullElseGet(day, () -> LocalDate.now()));
    }
    @Test
    public void test04(){
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        Thread thread = new Thread(new RunnableTest());
        thread.start();

    }

}
    class ThreadTest extends Thread{
        @Override
        public void run() {
            System.out.println("hello myThread");
        }
    }
    class RunnableTest implements Runnable{
        @Override
        public void run() {
            System.out.println("hello myRunnable");
        }
    }
    class CallableTest implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "success";
        }
    }


