package com.sjl.service.impl;

import com.sjl.bean.User;
import com.sjl.dao.IUserDao;
import com.sjl.dao.impl.IUserDaoImpl;
import com.sjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * @author Administrator
 *
 * <bean id="userService" class="com.sjl.service.impl.UserServiceImpl"
 *      scope="" init-method="" destroy-method="">
 *      <property name="" value="" /ref=""></property>
 *  </bean>
 * 用于创建对象的
 * @Service   @Component    @Repository
 * 用户依赖注入的
 * 用于改变作用范围的
 * 和生命周期相关的
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    /**
     * @Autowired  自动按类型注入（id和类型），IOC中只有唯一的一个id对应时，可以注入，当出现两个类型一致时，id不同，会报错
     * @Qualifier  在按照类注入的基础上再按照名称注入。它在给类成员注入时不能单独使用，但在给方法参数注入时可以
     * @Resource   直接按照bean的id注入，可以独立使用
     *  属性 name： 用于指定bean的id
     *      以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型的数据无法通过上述注解实现
     *      另外，集合类型的注入只能通过xml实现
     *
     * @value 用于注入基本类型和String类型的数据
     * 属性：
     *  value 用于指定数据的值，可以使用spring中的SpEL(也就是spring中的EL表达式)
     *          SpEL写法：${表达式}
     *
     * scope:
     *      用于指定bean的作用范围
     *
     *
     */
//    @Autowired
//    @Qualifier(value = "userDao")
    @Resource(name="userDao")
    private IUserDao userDao ;

    /*public UserServiceImpl() {
        System.out.println("UserServiceImpl 对象创建了。。。");
    }*/


    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    /**
     * 初始化
     */
    @PostConstruct
    public void init() {
        System.out.println("init...");
    }

    /**
     * 销毁
     */
    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }
}
