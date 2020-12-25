package com.sjl.service.impl;

import com.sjl.bean.Account;
import com.sjl.dao.IAccountDao;
import com.sjl.service.IAccountService;
import com.sjl.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * @author Administrator
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private TransactionManager transactionManager;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        accountDao.updateAccount(source);
        //模拟异常
       // int a = 1/0;
        accountDao.updateAccount(target);
       /* try {
            transactionManager.beginTransaction();
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.updateAccount(source);
            //模拟异常
            int a = 1/0;
            accountDao.updateAccount(target);
            //提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //回滚事务
            transactionManager.rollback();
            throw new RuntimeException("异常回滚事务");
        } finally {
            //释放连接
            transactionManager.release();
        }*/
    }
}
