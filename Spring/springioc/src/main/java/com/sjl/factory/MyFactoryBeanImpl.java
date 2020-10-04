package com.sjl.factory;

import com.sjl.bean.Book;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * @author Administrator
 *
 * 实现了FactoryBean接口的类，都是Spring认可的工厂类
 *  spring会调用工厂方法创建实例
 */
public class MyFactoryBeanImpl implements FactoryBean<Book> {
    /**
     * 工厂方法
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setBookName(UUID.randomUUID().toString().replace("-",""));
        return book;
    }

    /**
     * 返回创建对象的类型
     * spring会自动调用这个方法，来确认对象师什么类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    /**
     * 不是单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
