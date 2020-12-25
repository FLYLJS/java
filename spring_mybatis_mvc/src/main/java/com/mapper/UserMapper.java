package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert({"insert into user (username,age,money,address,phone) values (#{username},#{age},#{money},#{address},#{phone})"})
    void saveUser(User user);
}
