package com.sjl.core;

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
    }
}
