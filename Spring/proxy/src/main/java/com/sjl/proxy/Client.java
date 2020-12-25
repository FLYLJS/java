package com.sjl.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();
//        producer.saleProduct(10000f);
        /**
         * 动态代理
         * 字节码随用随创建，随用随加载
         *      不修改源码对方法进行增强
         *  分类：
         *      基于接口
         *      基于子类
         *  基于接口：Proxy  (JDK官方)
         *      被代理类至少实现一个接口，如果没有则不能使用
         *       newProxyInstance
         *          参数：
         *              ClassLoader:加载被代理对象的字节码
         *              Class[]：让代理对象和被代理对象有相同的方法
         *              InvocationHandler:提供增强的代码
         */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法，都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @return  和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强的代码
                        Object returnValue = null;
                        Float money = (Float) args[0];
                        //
                        if("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer,money*0.8f);
                        }
                        return returnValue;
                    }
                }
        );
        proxyProducer.saleProduct(10000f);
    }
}
