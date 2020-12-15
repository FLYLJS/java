import com.sjl.dao.IAccountDao;
import com.sjl.dao.IUserDao;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

@CacheNamespace  //开启二级缓存
public class AccountTest {
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Test
    public void testFindAll(){
//        accountDao.findAll().stream().forEach(System.out::println);
    }


    @Before
    public void init() throws Exception {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }
    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }
}
