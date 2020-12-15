package com.sjl.factory;

import com.sjl.service.UserService;
import com.sjl.service.impl.UserServiceImpl;

/**
 * 模拟一个静态工厂类，该类可能存在于jar包中，无法通过修改源码的方式，提供默认构造函数
 * @author Administrator
 */
public class StaticFactory {

    public static UserService getUserService(){return new UserServiceImpl();
    }

}
