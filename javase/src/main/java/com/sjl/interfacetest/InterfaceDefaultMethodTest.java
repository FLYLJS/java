package com.sjl.interfacetest;

/**
 * @author Administrator
 */
public class InterfaceDefaultMethodTest implements DefaultMethod,DefaultMethodSun{

    public static void main(String[] args) {
        /**
         *   sun  value  10
         *
         *   如果在接口中定义一个方法为默认方法，然后在其超类 或者另一个接口中定义同样的方法：
         *
         *   1.超类的同名的相同参数的方法会被忽略
         */
        System.out.println(new InterfaceDefaultMethodTest().getString(10));
    }
}
