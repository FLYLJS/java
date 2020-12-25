package com.sjl.dao;

import com.sjl.bean.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAccountDao {

    /**
     * 岔村所有账户信息
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);


    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
