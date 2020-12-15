package com.sjl.dao;

import com.sjl.bean.User;

/**
 * @author Administrator
 */
public interface IUserDao {

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);
}
