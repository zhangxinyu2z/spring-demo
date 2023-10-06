import com.z2xinyu.mybatis.config.mapper.OrderMapper;
import com.z2xinyu.mybatis.config.po.Order;
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

public class OrderMapperTest {
    /**
     * 用来创建sqlsession对象的工厂
     */
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        InputStream resource = Resources.getResourceAsStream("sqlMapConfig2.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order().setUserId(1).setNumber("1003010101").setCreatetime(new Date()).setNote("dress");
        mapper.insert(order);
        sqlSession.commit();
    }

    @Test
    public void queryAllOrdersTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.queryAllOrder();
        System.out.println(orders);
    }

    /**
     * 一对一关联查询，一个订单对应一个User
     */
    @Test
    public void selectAllOrder() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orders = mapper.selectAllOrder();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    /**
     * @Select使用动态sql
     */
    @Test
    public void findOrderFilter() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderFilter = mapper.findOrderFilter(new Order().setUserId(1));
        System.out.println(orderFilter);
        List<Order> orders = mapper.queryOrderByParam(new Order().setUserId(1).setNumber("10030"));
        System.out.println(orders);
    }

    @Test
    public void updateOrder() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        int update = mapper.update(new Order().setId(7).setNote("dress").setNumber("1003010101"));
        System.out.println("update==" + update);
    }

}
