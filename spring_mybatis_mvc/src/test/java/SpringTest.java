import com.domain.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private  UserService userService;
    @Test
    public void test(){
//        System.out.println(userService.findById(11));
        userService.transfer(11,12,10);
//        User user = new User();
//        user.setMoney(10000.0);
//        user.setId(11);
//        userService.updateUser(user);
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        User user = applicationContext.getBean("user", User.class);
//        user.setUsername("12");
//        System.out.println("用户名: "+user.getUsername());
//        UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);

    }
}
