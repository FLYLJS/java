package com.sjl.interfacetest;

public interface OtherInterfaceDefaultMethod {

    /**
     * 接口中默认方法
     * @param integer
     * @return
     */
    default String getString(Integer integer){
        return String.valueOf("other default method value  "+integer);
    }
}
