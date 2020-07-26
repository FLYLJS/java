package com.sjl.test;

import com.sjl.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis测试
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //生产SqlSession对象
        SqlSession openSession = factory.openSession();
        //动态代理创建Dao接口的代理对象
        UserDao userDao = openSession.getMapper(UserDao.class);
        //使用代理对象执行方法
        userDao.findAll().stream().forEach(u -> {
            System.out.println(u);
        });
        //释放资源
        openSession.close();
        in.close();
    }
}
