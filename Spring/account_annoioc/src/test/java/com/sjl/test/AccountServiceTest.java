package com.sjl.test;

import com.sjl.bean.Account;
import com.sjl.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * junit单元测试
 */
public class AccountServiceTest {

    private ApplicationContext applicationContext ;
    private AccountServiceImpl accountService ;

    @Before
    public void beforeMethod(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = applicationContext.getBean("accountService", AccountServiceImpl.class);
    }
    @Test
    public void testFindAll() {
        accountService.findAllAccount().stream().forEach(account-> System.out.println(account));
    }
    @Test
    public void testFindOne() {
        System.out.println(accountService.findAccountById(1));
    }
    @Test
    public void testFindSave() {
        Account account = new Account();
        account.setMoney(9000);
        account.setName("amn");
        accountService.saveAccount(account);
    }
}
