package com.z2xinyu.jdbctemplate;

import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 测试JDBCTemplate的crdud方法
 *
 */
public class JdbcTemplateTest extends SpringDemoJdbctemplateApplicationTest{

    @Autowired
    private JdbcTemplate jdbcTemplate;
/*    private static final JdbcTemplate jdbcTemplate;

    static {
        // 设置mysql数据库连接信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///mp_demo?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    @Test
    public void testAdd() {
        String sql = "insert into goods_spu (id, seller_id, category_id1, name,goods_state) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, "10034050", "100000063688", "15335","wangwuh", 1);
    }

    @Test
    public void testUpdate() {
        String sql = "update goods_spu set name = ? where id = ?";
        Object[] params = {"spring-ioc", "10034050"};
        jdbcTemplate.update(sql, params);
    }

    @Test
    public void testDelete() {
        String sql = "delete  from goods_spu where id = ?";
        jdbcTemplate.update(sql, "10034050");
    }

    /**
     * 查询单行单列数据
     */
    @Test
    public void testQuery() {
        String sql = "select count(*) from goods_spu where goods_state = ?";
        Integer count = jdbcTemplate.queryForObject(sql, int.class, 1);

        System.out.println(count);
    }

    /**
     * 将一行数据映射为一个对象
     */
    @Test
    public void testQueryObject() {
        String sql = "select * from goods_spu where id = ?";
        // rowMapper : 将结果集映射成指定的对象，参考dbutils中的ResultHandler，都是将ResultSet中的数据封装
        GoodsSpu goodsSpu = jdbcTemplate.queryForObject(sql, new RowMapper<GoodsSpu>() {
            @Override
            public GoodsSpu mapRow(ResultSet rs, int i) throws SQLException {
                GoodsSpu goodsSpu = new GoodsSpu();
                goodsSpu.setId(rs.getString("Id"));
                goodsSpu.setName(rs.getString("name"));
                return goodsSpu;
            }
        }, "10034050");
        System.out.println(goodsSpu);
    }

    /**
     * 将查询结果封装为对象集合
     */
    @Test
    public void testQueryList() {
        String sql = "select * from goods_spu";
        List<GoodsSpu> bookList = jdbcTemplate.query(sql, new RowMapper<GoodsSpu>() {
            @Override
            public GoodsSpu mapRow(ResultSet rs, int i) throws SQLException {
                GoodsSpu goodsSpu = new GoodsSpu();
                goodsSpu.setId(rs.getString("Id"));
                goodsSpu.setName(rs.getString("name"));
                return goodsSpu;
            }
        });
        System.out.println(bookList);
    }
}
