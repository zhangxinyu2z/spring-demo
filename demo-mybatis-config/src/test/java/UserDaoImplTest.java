import com.z2xinyu.mybatis.config.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 原始dao的操作方法
 * <p>
 * 1、sqlSessionBuilder构建sqlSessionFactory
 * 2、dao接口的实现类注入sqlSessionFactory，调用openSession()生成类似Connection对象的SqlSession对象来执行sql操作
 * <p>
 * 为什么使用Mapper代理方式？
 * 1、sqlSessionFactory创建一次就够了
 * 2、每个dao都要注入sqlSessionFactory，每个方法都要openSession
 * 3、关注数据的结构：selectOne还是SelectList
 * 4、每个dao都要编写实现类和mapper.xml
 *
 * @author Arnoer
 * @since 2022/9/23 10:32
 */
public class UserDaoImplTest {
    // 初始创建一次
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        // 1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 2. 加载SqlMapConfig.xml配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 3. 创建SqlSessionFactory对象
        this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    @Test
    public void queryUserById() throws IOException {
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 5. 执行SqlSession对象执行查询，获取结果User
        // 第一个参数是User.xml的statement的id，第二个参数是执行sql需要的参数；
        Object user = sqlSession.selectOne("com.arnoer.basic.po.User.queryUserById", 1);

        // 6. 打印结果
        System.out.println(user);
        System.out.println(System.getProperty("file.encoding"));

        // 7. 释放资源
        sqlSession.close();
    }

    @Test
    public void queryUserByUserName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("queryUserByUserName", "王");
        users.forEach(System.out::println);
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("李师师");
        user.setBirthday(new Date());
        user.setAddress("汴京");
        user.setSex("女");
        int rows = sqlSession.insert("insert", user);
        // 开启了事务，需要commit
        sqlSession.commit();
        // 需求是：当前注册的用户,立刻下了一条订单，需要得到mysql自动增长生成的id
        System.out.println("rows:" + rows + "--userId:" + user.getId());
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("王祖贤");
        user.setSex("女");
        int rows = sqlSession.update("updateUser", user);
        sqlSession.commit();
        System.out.println(rows);
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int rows = sqlSession.delete("deleteUserById", 29);
        sqlSession.commit();
        System.out.println(rows);
    }
}