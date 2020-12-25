package com.sjl.proxy;

/**
 * @author Administrator
 *
 * 生产者
 */
public class Producer implements IProducer{

    @Override
    public void saleProduct(Float money){
        System.out.println("销售产品："+money+"元");
    }

    @Override
    public void afterService(Float money){
        System.out.println("售后服务："+money+"元");
    }
}
