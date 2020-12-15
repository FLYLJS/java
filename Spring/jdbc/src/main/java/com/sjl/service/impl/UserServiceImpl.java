package com.sjl.service.impl;

import com.sjl.bean.User;
import com.sjl.dao.IUserDao;
import com.sjl.dao.impl.IUserDaoImpl;
import com.sjl.factory.BeanFactory;
import com.sjl.service.UserService;

/**
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

//    private IUserDao userDao = new IUserDaoImpl();
    IUserDao userDao = (IUserDao) BeanFactory.getBean("userDao");
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
