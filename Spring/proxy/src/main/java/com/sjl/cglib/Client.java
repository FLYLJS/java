package com.sjl.cglib;

import com.sjl.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Administrator
 *
 * 基于子类的动态代理  cglib
 */
public class Client {

    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         * 动态代理
         * 字节码随用随创建，随用随加载
         *      不修改源码对方法进行增强
         *  分类：
         *      基于接口
         *      基于子类
         *  基于子类：Enhancer (第三方cglib库)
         *      被代理类不能是最终类
         *  参数；
         *      Class :被代理对象的字节码
         *      Callback:方法增强
         */
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *  执行被代理对象的任何方法都会经过此方法
             * @param proxy
             * @param method
             * @param args
             * @param proxy  当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //增强的代码
                Object returnValue = null;
                Float money = (Float) args[0];
                //
                if("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
       cglibProducer.saleProduct(12000f);
    }
}
