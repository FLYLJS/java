package com.sjl.interfacetest;

/**
 * @author Administrator
 */
public class OtherInterfaceDefaultMethodTest implements DefaultMethod ,OtherInterfaceDefaultMethod{

    /**
     *
     * 接口冲突
     *
     * 2.如果一个类实现了两个接口，接口中都有同名的而且参数相同的方法，必须覆盖这个方法
     *
     * @param integer
     * @return
     */
    @Override
    public String getString(Integer integer) {
        return DefaultMethod.super.getString(10);
    }
}
