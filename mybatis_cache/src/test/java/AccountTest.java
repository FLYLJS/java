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

public class AccountTest {

    private static Logger logger = LoggerFactory.getLogger(AccountTest.class);
    private InputStream resourceAsStream = null;
    private SqlSession sqlSession = null;
    private IUserDao iUserDao= null;


    /**
     * 缓存测试
     */
    @Test
    public void test01() throws IOException {
        User user = iUserDao.findById(1);
        System.out.println(user);
        user.setUsername("sl");
        user.setAddress("北京市");
        iUserDao.updateById(user);
        //清空缓存
//        sqlSession.close();
//        sqlSession.clearCache();
//        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
//        iUserDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(iUserDao.findById(1));
    }

    @Before
    public void init(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
//            iAccount = sqlSession.getMapper(IAccount.class);
             iUserDao = sqlSession.getMapper(IUserDao.class);
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
