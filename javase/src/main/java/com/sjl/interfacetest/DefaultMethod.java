package com.sjl.interfacetest;

/**
 * @author Administrator
 */
public interface DefaultMethod {
    /**
     * 接口中默认方法
     * @param integer
     * @return
     */
    default String getString(Integer integer){
        return String.valueOf("father value  "+integer);
    }
}
