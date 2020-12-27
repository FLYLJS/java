package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User findById(Integer id);

    void updateUser(User user);

    void transfer(Integer sid,Integer tid,double money);
}
