package com.sjl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 *  使用ThreadLocal对象把Connection与当前线程绑定，使一个线程中只能有一个控制事务的对象
 * 连接工具类
 *
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;


    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            //获取当前线程上的连接
            Connection connection = threadLocal.get();
            //判断当前线程是否有链接
            if(connection == null){
                connection = dataSource.getConnection();
                //绑定线程
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
