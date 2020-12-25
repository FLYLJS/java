package com.sjl.factory;

import com.sjl.service.IAccountService;
import com.sjl.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象工厂
 */
@Component("beanFactory")
public class BeanFactory {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager  transactionManager;

    public final void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService(){
        return  (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            transactionManager.beginTransaction();
                            rtValue = method.invoke(accountService,args);
                            //提交事务
                            transactionManager.commit();
                            return rtValue;
                        } catch (Exception e) {
                            //回滚事务
                            transactionManager.rollback();
                            throw new RuntimeException("异常回滚事务");
                        } finally {
                            //释放连接
                            transactionManager.release();
                        }
                    }
                });
    }
}
