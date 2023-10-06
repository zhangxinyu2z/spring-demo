import com.z2xinyu.mybatis.config.mapper.UserMapper;
import com.z2xinyu.mybatis.config.po.Order;
import com.z2xinyu.mybatis.config.po.QueryVo;
import com.z2xinyu.mybatis.config.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arnoer
 * @since 2022/9/23 10:56
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void createSqlSessionFactory() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapConfig2.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    }

    @Test
    public void findUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // sqlSession通过提供的接口Class对象，生成一个UserMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        /**
         * 通过方法名、参数和返回值类型，去mapper.xml查找对应有sql,根据返回值判断调用selectone 还是selecetList
         */
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    /**
     * vo作为参数
     */
    @Test
    public void queryUserByUserName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("王");
        queryVo.setUser(user);
        List<User> users = mapper.queryUserByUserName(queryVo);
        System.out.println(users);
    }

    /**
     * po中的多字段查询。where标签
     */
    @Test
    public void queryUserBySexAndName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("王");
        /*   user.setSex("女");*/
        List<User> users = mapper.queryUserBySexAndName(user);
        System.out.println(users);
    }

    /**
     * 通过vo中的list查询
     *
     */
    @Test
    public void queryUserByIds() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo queryVo = new QueryVo();
        List<Integer> idList = new ArrayList<>();
        idList.add(16);
        idList.add(22);
        idList.add(24);
        queryVo.setIdList(idList);
        List<User> users = mapper.queryUserByIds(queryVo);
        System.out.println(users);
    }

    /**
     * 直接传递array类型
     */
    @Test
    public void queryUserByIdsOfArrayTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer[] ids = new Integer[]{10, 16, 22};
        List<User> users = mapper.queryUserByIdsOfArray(ids);
        System.out.println(users);
    }

    /**
     * 直接传递list类型参数
     */
    @Test
    public void queryUserByIdsOfListTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryUserByIdsOfList(Arrays.asList(10,16,22));
        System.out.println(users);
    }


    /**
     * 接收map参数
     */
    @Test
    public void queryUserByIdsOfMapTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer[]> map = new HashMap<>();
        Integer[] ids = new Integer[]{10, 16, 22};
        map.put("ids",ids);
        List<User> users = mapper.queryUserByIdsOfMap(map);
        System.out.println(users);
    }

    /**
     * 测试queryvo中的数组
     */
    @Test
    public void queryUserByVoIdsTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        Integer[] ids = new Integer[]{10, 16, 22};
        vo.setIds(ids);
        List<User> users = mapper. queryUserByVoIds(vo);
        System.out.println(users);
    }

    @Test
    public void queryAllUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 延迟加载案例：
     * 用户有100个订单
     *
     * 查询用户时，不要要查询订单，需要的时候再加载
     * 查询用户订单，用户的信息应该一起加载出来
     *
     * 查询订单，获取用户的信息
     *
     * 延迟加载该用户信息，需要订单信息的时候才去加载
     * 需要配置开启延迟加载
     */
    @Test
    public void findUserOrdersLazyLoading() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // debug查看sql打印日志
        User userById = mapper.findUserInfo(1);
        System.out.println(userById.getClass());

        // 第二步
        List<Order> orderList = userById.getOrderList();

    }
}