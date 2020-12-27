package com.service.impl;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void transfer(Integer sid, Integer tid, double money){
        User su = userMapper.findById(sid);
        su.setMoney(su.getMoney()-money);
        userMapper.updateUser(su);
//        int a = 1/0;
        User tu = userMapper.findById(tid);
        tu.setMoney(tu.getMoney()+money);
        userMapper.updateUser(tu);

    }
}
