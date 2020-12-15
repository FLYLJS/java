package com.sjl.service.impl;

import com.sjl.bean.User;
import com.sjl.service.UserService;

import java.util.Date;

/**
 * @author Administrator
 */
public class UserServiceImpl2 implements UserService {
    /**
     * 经常变化的数据，并不适用于注入的方式
     */
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void insertUser(User user) {
        System.out.println("service  方法执行。。。"+name+","+age+","+birthday);
    }

}
