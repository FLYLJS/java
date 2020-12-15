package com.sjl.ui;

import com.sjl.bean.User;
import com.sjl.dao.IUserDao;
import com.sjl.service.impl.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Administrator
 */
public class Client {

    /**
     *  获取IOC
     *  ApplicationContext实现类：------->单例对象适用
     *              ClassPathXmlApplicationContext：类路径下的配置文件
     *              FileSystemXmlApplicationContext：磁盘下任意路径（必须有访问权限）
     *              AnnotationConfigApplicationContext:用于读取注解创建容器
     *  ApplicationContext：
     *      在构建核心容器时，创建对象的策略是采取立即加载的方式，读取完配置文件，马上就创建配置文件中配置的对象
     *  BeanFactory:---------->多例对象适用
     *      在构建核心容器时，创建对象的方式采用延迟加载。
     * @param args
     */
    public static void main(String[] args) {
/*        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        IUserDao userDao = context.getBean("userDao", IUserDao.class);*/

        // ----------------BeanFactory-----------------
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        UserServiceImpl userService = factory.getBean("userService", UserServiceImpl.class);
        IUserDao userDao = factory.getBean("userDao", IUserDao.class);

    }
}
