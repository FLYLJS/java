package com.sjl.ui;


import com.sjl.bean.User;
import com.sjl.service.impl.UserServiceImpl;
import com.sjl.service.impl.UserServiceImpl2;
import com.sjl.service.impl.UserServiceImpl3;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Administrator
 */
public class Client {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl3 userService = context.getBean("userService3", UserServiceImpl3.class);
        userService.insertUser(new User());

    }
}
