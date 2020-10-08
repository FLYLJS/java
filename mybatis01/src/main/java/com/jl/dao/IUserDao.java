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
    /**
     *   根据id查询用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据姓名查询用户
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 统计总的数量
     *
     * @return
     */
    Integer countTotal();

    /**
     * 根据条件查询
     *
     * @param user
     * @return
     */
    List<User> findByCondition(User user);

    /**
     *
     * <foreach></foreach>
     * @param user
     * @return
     */
    List<User> findUserInIds(User user);
}
