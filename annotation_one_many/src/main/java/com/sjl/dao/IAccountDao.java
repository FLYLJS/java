package com.sjl.dao;

import com.sjl.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author Administrator
 */
public interface IAccountDao {

    /**
     * 查询所有账户，获取每个账户所属的用户信息
     * 一对一
     * @return
     */
    @Select("SELECT * FROM account")
    @Results(id = "accountMap" ,value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            //根据uid查询用户信息
            @Result(property = "user",column = "uid",one = @One(select ="com.sjl.dao.IUserDao.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据uid查询账户
     * @param uid
     * @return
     */
    @Select("select *from account where uid =#{uid}")
    List<Account> findByUid(Integer uid);
}
