package com.sjl.service.impl;

import com.sjl.bean.User;

import com.sjl.service.UserService;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {



    public UserServiceImpl() {
        System.out.println("UserServiceImpl 对象创建了。。。");
    }

    public void insertUser(User user) {
        System.out.println("service  方法执行。。。");
    }
    public void init() {
        System.out.println("对象初始化。。。");
    }
    public void destroy() {
        System.out.println("对象销毁。。。");
    }
}
