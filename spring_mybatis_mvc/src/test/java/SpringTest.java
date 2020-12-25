import com.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = applicationContext.getBean("user", User.class);
        user.setUsername("12");
        System.out.println("用户名: "+user.getUsername());
    }
}
