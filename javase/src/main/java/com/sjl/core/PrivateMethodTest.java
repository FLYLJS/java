package com.sjl.core;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 * @deprecated 反射获取类的私有方法
 */
public class PrivateMethodTest {
    @Test
    public void test01(){
        Class<CoreTechnologies> coreTechnologiesClass = CoreTechnologies.class;
        try {
            Method getString = coreTechnologiesClass.getDeclaredMethod("getString", String.class);
            System.out.println(getString.getName());
            getString.setAccessible(true);
            System.out.println(getString.invoke(coreTechnologiesClass.newInstance(), "js"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
