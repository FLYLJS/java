package com.sjl.interfacetest;

/**
 * @author Administrator
 */
public interface DefaultMethodSun extends DefaultMethod{

    /**
     * 接口中默认方法
     * @param integer
     * @return
     */
    default String getString(Integer integer){
        return String.valueOf("sun  value  "+integer);
    }
}
