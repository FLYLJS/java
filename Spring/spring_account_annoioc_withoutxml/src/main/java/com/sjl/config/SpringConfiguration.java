package com.sjl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author Administrator
 * @Configuration :表明当前类是一个配置类
 * 配置类  替代applicationContext.xml
 * 当SpringConfiguration.class 被 new AnnotationConfigApplicationContext()作为参数传入时，配置类可以省略 @Configuration注解
 * @ComponentScan :包扫描
 * value/basePackages:指定创建容器时要扫描的包
 * <context:component-scan base-package="com.sjl"/>
 * @Bean: 把当前方法的返回值，作为bean对象存入spring容器中
 * 属性：
 * name：用于指定bean的id，
 * <p>
 * 使用注解配置方法时，如果方法带参数，spring框架回去容器中查找有没有可用的bean
 * 查找的方式和@autowired的方式是一样的，自动按照类型注入
 * @Import(JdbcConfig.class) 引入其他配置类
 *
 * @PropertySource("classpath:jdbcConfig.properties") :用于指定properties文件的位置
 */
@Configuration
@ComponentScan(basePackages = "com.sjl")
@Import(JdbcConfig.class)
public class SpringConfiguration {


}
