package com.sjl.cglib;

import com.sjl.proxy.IProducer;

/**
 * @author Administrator
 *
 * 生产者
 */
public class Producer  {


    public void saleProduct(Float money){
        System.out.println("销售产品："+money+"元");
    }


    public void afterService(Float money){
        System.out.println("售后服务："+money+"元");
    }
}
