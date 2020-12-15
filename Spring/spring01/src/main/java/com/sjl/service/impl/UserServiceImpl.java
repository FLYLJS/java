package com.sjl.service.impl;

import com.sjl.bean.User;
import com.sjl.dao.IUserDao;
import com.sjl.dao.impl.IUserDaoImpl;
import com.sjl.service.UserService;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

    private IUserDao userDao = new IUserDaoImpl();

    public UserServiceImpl() {
        System.out.println("UserServiceImpl 对象创建了。。。");
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
