package com.sjl.core;

import org.junit.Test;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Administrator
 */
public class CoreTechnologies {
    /**
     * 枚举类型
     */
    enum Size {
        SMALL,
        MEDIUM,
        LARGE,
        EXTRA_LARGE
    };
    public static void main(String[] args) {
        System.out.println(Size.LARGE);
        //平方根
        System.out.println(Math.sqrt(12));
        //幂运算   2的3次方
        System.out.println(Math.pow(2, 3));
        System.out.println(String.join("-", "j", "a", "v", "a"));
        //𝕆   一般普通字符为一个代码单元，辅助字符需要两个代码单元
        String greeting = "Hello";

        String china = "china";
        Integer n = 0;
        System.out.println("【返回位置n的代码单元】"+china.charAt(n));
//        System.out.println(china.codePointCount(0, china.length()));
        //得到第一个码点
        int index = china.offsetByCodePoints(0, n);
        System.out.println(china.codePointAt(index));
        System.out.println(china.indexOf("n")+china.length());
        //JDK 11
        System.out.println(greeting.repeat(3));
        switch (china){
            case "china" :
                System.out.println("中华人民共和国");
                break;
            case "English" :
                System.out.println("英格兰");
                break;
            case "Japan" :
                System.out.println("我是小日本子");
                break;
            default:
                System.out.println("中华人民共和国");
        }
        //从offset索引位置开始插入
        System.out.println(new StringBuilder(greeting).insert(5, " World").toString());
    }
    /**
     * LocalDate
     */
    @Test
    public void test01(){
        String name = null;

        //使用静态工厂来构造LocalDate对象
        //返回当前年月日
        System.out.println(LocalDate.now());
        //返回当前月
        System.out.println(LocalDate.now().getMonthValue());
        //当前日期的下个月
        System.out.println(LocalDate.now().plusMonths(1));
//      =====================   此处会抛异常  =========================
        Objects.requireNonNull(name,"The name cannot be  null");
//      ====================== java 9 String is null  =========================
        System.out.println(Objects.requireNonNullElse(name,"unknown"));
        System.out.println(getString(name));
    }

    private  String getString(String name){
        System.out.println("==="+name);
        return Objects.requireNonNullElse(name,"JC");
    }

    /**
     * NumberFormat
     */
    @Test
    public void test02(){
//       =================   转换为百分数  15% =================
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        System.out.println("百分比  "+percentInstance.format(0.15));
//      ==================  转换为货币比例  ¥11.15 =================
        System.out.println(NumberFormat.getCurrencyInstance().format(11.15));

        double percent = 10.0;
        tripleValue(percent);
//      ================   10
        System.out.println(percent);
    }

    public static void tripleValue(double v){
        v = v * 3;
    }


}
