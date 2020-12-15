package com.sjl.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Administrator
 *
 * 创建bean的工厂
 * Javabean  可重用组件
 *   1、需要一个配置文件来配置service和dao
 *
 *   2、通过读取配置文件中的内容，单设反射创建对象
 *
 *   xml   properties
 *
 */
public class BeanFactory {

    private static Properties properties;

    /**
     *     定义一个map用于存放我们要创建的对象-->容器
     */
    private static Map<String,Object> beans;


    static {
        try {
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String, Object>(16);
            //取出配置文件中所有的kay
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object instance = Class.forName(beanPath).newInstance();
                //把key和value存入map中
                beans.put(key,instance);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties异常");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){

        //多例对象
/*        Object bean = null;
        try {
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;*/

        //单例对象
        return beans.get(beanName);
    }

}
