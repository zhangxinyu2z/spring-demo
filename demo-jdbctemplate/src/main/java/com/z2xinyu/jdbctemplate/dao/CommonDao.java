package com.z2xinyu.jdbctemplate.dao;

import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author zhangxinyu
 * @date 2023/7/5
 **/
public class CommonDao extends JdbcDaoSupport {

    public List<GoodsSpu> findById(String id) {
        String sql = "select * from goods_spu where id = ?";
        return this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(GoodsSpu.class), id);
    }
}
