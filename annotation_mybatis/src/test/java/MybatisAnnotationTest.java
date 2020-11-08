import com.sjl.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisAnnotationTest {

    /**
     * mybatis注解使用
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //获取字节输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //构建对象工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        //生产SqlSession
        SqlSession sqlSession = factory.openSession();
        //获取代理对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.findAll().stream().forEach(user-> System.out.println(user));
        //释放资源
        sqlSession.close();
        inputStream.close();
    }
}
