import com.jl.bean.Role;
import com.jl.dao.IAccount;
import com.jl.dao.IRoleDao;
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

public class RoleTest {

    private static Logger logger = LoggerFactory.getLogger(RoleTest.class);
    private InputStream resourceAsStream = null;
    private SqlSession sqlSession = null;
    private IRoleDao iRoleDao;

    @Test
    public void testFindAll(){
        List<Role> roles = iRoleDao.findAll();
        for (Role role : roles) {
            logger.info(role.toString());
            logger.info(role.getUsers().toString());
        }
    }

    @Before
    public void init(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            iRoleDao = sqlSession.getMapper(IRoleDao.class);
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
