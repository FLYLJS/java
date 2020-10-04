import com.jl.bean.User;
import com.jl.dao.IUserDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    @Test
    public void test02(){
        InputStream resourceAsStream = null;
        SqlSession sqlSession = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            logger.info(sqlSession.getMapper(IUserDao.class).findById(2).toString());
            logger.info(sqlSession.getMapper(IUserDao.class).findByName("ac").toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test01() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        sqlSession.getMapper(IUserDao.class).findAll().stream().forEach(user ->
            System.out.println(user)
        );
        sqlSession.close();
        resourceAsStream.close();
    }
}


