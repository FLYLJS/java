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

public class SecondLevelCacheTest {

    private static Logger logger = LoggerFactory.getLogger(SecondLevelCacheTest.class);
    private InputStream resourceAsStream =  null;
    private SqlSession sqlSession = null;
    private IUserDao iUserDao= null;
    private SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

    public SecondLevelCacheTest() throws IOException {
    }

    /**
     * 二级缓存测试
     */
    @Test
    public void test01() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(iUserDao.findById(1));
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = sqlSessionFactoryBuilder.build(resourceAsStream).openSession();
        iUserDao = sqlSession.getMapper(IUserDao.class);
        System.out.println(iUserDao.findById(1));
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
