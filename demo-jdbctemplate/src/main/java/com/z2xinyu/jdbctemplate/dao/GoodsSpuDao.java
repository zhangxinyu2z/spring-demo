package com.z2xinyu.jdbctemplate.dao;

import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhangxinyu
 * @date 2023/7/5
 **/
@Component
public class GoodsSpuDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int updateGoodsSpu(GoodsSpu goodsSpu) {
        return jdbcTemplate.update("update goods_spu set name = ? where id = ?", goodsSpu.getName(),
            goodsSpu.getId());
    }
}
