import com.sjl.bean.Car;
import com.sjl.bean.Person;

//import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Map;

public class IOCTest {
    Logger logger = LoggerFactory.getLogger(IOCTest.class);
//    private static Logger logger = Logger.getLogger(IOCTest.class);
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    private ApplicationContext ioc2 = new ClassPathXmlApplicationContext("ioc2.xml");


    @Test
    public void test04(){
        Person person03 = ioc2.getBean("person03", Person.class);
        System.out.println(person03);
        Map<String,Object> myMap = ioc2.getBean("myMap",Map.class);
        System.out.println(myMap);
        logger.info("**************");
        /*
        * 级联属性会修改属性的值
        *   容器中的也会修改
        * */
        logger.info("容器中的："+ioc2.getBean("car01", Car.class).toString(),new Date());
        Person person04 = ioc2.getBean("person04", Person.class);
        logger.info("pserson对象的:"+ person04.getCar(),new Date());
        logger.info("----------------");
        logger.info(ioc2.getBean("person06",Person.class).toString());
    }

    /**
     * 为各种属性赋值
     *
     *  默认引用类型为null
     *
     */
    @Test
    public void test03(){
       /* System.out.println(ioc2.getBean("person01",Person.class).getUsername() == null);
        System.out.println(ioc2.getBean("person01",Person.class));*/
//        System.out.println(ioc2.getBean("person02",Person.class));
        Person bean = ioc2.getBean("person02", Person.class);
        System.out.println(bean.getMaps());
        System.out.println("==============");
        System.out.println(bean.getProperties());
    }

    /**
     * 根据Bean的类型在ioc容器中获取bean实例
     * 如果，ioc容器中有多个这个类型的bean的实例，查找就会报错
     *
     * org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.sjl.bean.Person' available:
     * expected single matching bean but found 2: personone,persontwo
     */
    @Test
    public void test02(){
        /*Person person = ioc.getBean(Person.class);
        System.out.println(person);*/
        System.out.println(ioc.getBean("personthree", Person.class));
        System.out.println(ioc.getBean("personfour", Person.class));
    }
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person personone = applicationContext.getBean("personone",Person.class);
        Person persontwo = applicationContext.getBean("personone",Person.class);
        logger.info(personone.toString(),new Date());
//        logger.info(personone);
        System.out.println(personone==persontwo);
    }
}
