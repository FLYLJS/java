import com.sjl.controller.BookController;
import com.sjl.service.BookService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCBeanTest {

    private static Logger logger = LoggerFactory.getLogger(IOCBeanTest.class);
    private ApplicationContext ioc3 = new ClassPathXmlApplicationContext("ioc3.xml");
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * IOC容器的初始化
     *
     *  depends-on:控制bean实例化的顺序(默认为配置文件的配置顺序)
     */
    @Test
    public void  test01(){
        logger.info("容器启动完成。。。");
        Object airPlane02 = ioc3.getBean("airPlane02");
        logger.info(airPlane02.toString());
        /*
        * DEBUG - Creating shared instance of singleton bean 'person'
        * person 无参构造
        * DEBUG - Creating shared instance of singleton bean 'book'
        * book无参构造
        * DEBUG - Creating shared instance of singleton bean 'car'
        * car 无参构造
        *
        * */
    }


}
