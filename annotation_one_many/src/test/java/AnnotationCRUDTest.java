import com.sjl.dao.IUserDao;
import com.sjl.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class AnnotationCRUDTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Test
    public void testFindAll(){
        System.out.println(userDao.findAll());
    }

    @Test
    public void testFindById(){
        System.out.println(userDao.findById(8));
    }
    @Test
    public void testFindUserByName(){
        System.out.println(userDao.findUserByName("r"));
    }

    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
