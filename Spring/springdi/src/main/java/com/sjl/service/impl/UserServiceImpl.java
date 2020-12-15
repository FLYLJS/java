package com.sjl.service.impl;

import com.sjl.bean.User;
import com.sjl.service.UserService;

import java.util.Date;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {
    /**
     * 经常变化的数据，并不适用于注入的方式
     */
    private String name;
    private Integer age;
    private Date birthday;

    public UserServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void insertUser(User user) {
        System.out.println("service  方法执行。。。"+name+","+age+","+birthday);
    }

}
