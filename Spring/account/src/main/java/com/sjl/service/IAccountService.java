package com.sjl.service;

import com.sjl.bean.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层接口
 * @author Administrator
 */

public interface IAccountService {
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
     * 转账
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName,String targetName,Float money);
}
