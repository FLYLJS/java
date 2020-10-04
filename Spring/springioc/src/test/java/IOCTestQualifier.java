import com.sjl.controller.BookController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTestQualifier {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    @Test
    public void test(){
        ac.getBean("bookController", BookController.class).testAutowired();
    }
}
