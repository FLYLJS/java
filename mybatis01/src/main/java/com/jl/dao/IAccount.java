package com.jl.dao;

import com.jl.bean.Account;
import com.jl.bean.AccountUser;

import java.util.List;

public interface IAccount {

    List<Account> findAll();

    /**
     * 查询所有账户并且带账户的用户信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
