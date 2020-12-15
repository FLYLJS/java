package com.sjl.dao;

import com.sjl.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 *
 *  @Select  @Insert  @Update  @Delete
 *
 * @author Administrator
 */
public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    /**
     * 解决数据库字段和实体类字段名不一样
     * 可以通过id被别的地方引用
     *        @ResultMap(value = {"userMap"})
     */
    @Results(id = "userMap",value = {
            @Result(id=true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "age",property = "userAge"),
            @Result(column = "address",property = "userAddress"),
            //property user对象中的account集合，column user表的主键 ， fetchType  配置懒加载和立即加载
            @Result(property = "list",column = "id",many = @Many(select = "com.sjl.dao.IAccountDao.findByUid",fetchType = FetchType.DEFAULT))
    })
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param username
     * @return
     */
//    @Select("select * from user  where username like #{username}")
    @Select("select * from user  where username like '%${value}%'")
    @ResultMap(value = {"userMap"})
    List<User> findUserByName(String username);

}
