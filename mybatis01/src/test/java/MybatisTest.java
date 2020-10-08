import com.jl.bean.User;
import com.jl.dao.IUserDao;

import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MybatisTest {
    private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    private InputStream resourceAsStream = null;
    private SqlSession sqlSession = null;

    /**
     * <foreach></foreach>
     */
    @Test
    public void test04(){
        List<Long> list = Arrays.asList(1l, 3l, 5l);
        Supplier<User> aNew = User::new;
        User user = aNew.get();
        user.setIds(list);
        createIUser().findUserInIds(user).stream().forEach(
            System.out ::println
        );
    }
    @Test
    public void test03(){
        logger.info(String.valueOf(createIUser().countTotal()));
        Supplier<User> aNew = User::new;
        User user = aNew.get();
        user.setUsername("boolean");
        user.setSex("男");
        if(!createIUser().findByCondition(user).isEmpty()){
            logger.info(createIUser().findByCondition(user).iterator().next().toString());
        }else {
            logger.info("未匹配到人员");
        }
    }

    @Test
    public void test02(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            logger.info(sqlSession.getMapper(IUserDao.class).findById(2).toString());
            logger.info(sqlSession.getMapper(IUserDao.class).findByName("ac").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test01() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        sqlSession.getMapper(IUserDao.class).findAll().stream().forEach(user ->
            System.out.println(user)
        );
//        sqlSession.close();
//        resourceAsStream.close();
    }

    /**
     * 返回 接口
     * @return
     */
    public IUserDao createIUser(){
        try {
            resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession.getMapper(IUserDao.class);
    }
    @After
    public void closeStream(){
        try {
            resourceAsStream.close();
            sqlSession.close();
            logger.info("关流");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


