package com.jl.dao;

import com.jl.bean.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface IUserDao {
    /**
     * 查询所有信息
     * @return
     */
    List<User> findAll();

    User findById(Integer id);

}
