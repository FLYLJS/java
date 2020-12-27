package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert({"insert into user (username,age,money,address,phone) values (#{username},#{age},#{money},#{address},#{phone})"})
    void saveUser(User user);


    void transfer(Integer sid,Integer tid,double money);

    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    @Update({"update user set money = #{money} where id = #{id}"})
    void updateUser(User user);
}
