import com.sjl.bean.User;
import com.sjl.factory.BeanFactory;
import com.sjl.service.UserService;
import com.sjl.service.impl.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
        /**
         * 使用工厂创建对象
         */
        UserService userService = (UserService) BeanFactory.getBean("userService");
        User user = new User();
        userService.insertUser(user);
    }
}
