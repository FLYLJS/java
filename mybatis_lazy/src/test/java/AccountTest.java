import com.jl.dao.IAccount;
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
    private IAccount iAccount;


    /**
     * 查询所有
     */
    @Test
    public void test01(){
//        System.out.println("===》"+iAccount.findAll().get(0).toString());
        iAccount.findAll();
    }

    @Before
    public void init(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            iAccount = sqlSession.getMapper(IAccount.class);
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
