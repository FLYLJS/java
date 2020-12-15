package com.sjl.dao.impl;

import com.sjl.bean.User;
import com.sjl.dao.IUserDao;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class IUserDaoImpl implements IUserDao {

    public void insertUser(User user) {
        System.out.println("保存用户");
    }
}
