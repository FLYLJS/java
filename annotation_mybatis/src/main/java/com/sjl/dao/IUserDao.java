package com.sjl.dao;

import com.sjl.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Select  @Insert  @Update  @Delete
 *
 * @author Administrator
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("INSERT INTO user(username,age,sex,address) VALUES(#{username},#{age},#{sex},#{address})")
    void saveUser(User user);

    /**
     * 更新用户
     *
     * @param user
     */
    @Update("update user set username = #{username},age = #{age},address= #{address} where id = #{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user  where username like #{username}")
    @Select("select * from user  where username like '%${value}%'")
    List<User> findUserByName(String username);

    /**
     * 用户数量
     * @return
     */
    @Select("select count(1) from user")
    int findTotalUser();
}
