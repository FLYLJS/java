package com.sjl.proxy;


/**
 * 对生产产家要求的
 */
public interface IProducer {

    public void saleProduct(Float money);

    public void afterService(Float money);
}
