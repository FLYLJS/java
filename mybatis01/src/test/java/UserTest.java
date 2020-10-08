import com.jl.bean.User;
import com.jl.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private static Logger logger = LoggerFactory.getLogger(UserTest.class);
    private InputStream resourceAsStream = null;
    private SqlSession sqlSession = null;
    private IUserDao userDao;

    @Test
   public void testFindAll(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println("-----每个用户的信息-----");
            System.out.println(user);
            System.out.println(user.getAccount());
        }
    }

    @Before
    public void init(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            userDao = sqlSession.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destroy(){
        try {
            resourceAsStream.close();
            sqlSession.close();
            logger.info("关流");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
