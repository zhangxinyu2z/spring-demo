package com.z2xinyu.jdbctemplate.dao;

import com.z2xinyu.jdbctemplate.SpringDemoJdbctemplateApplicationTest;
import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
public class CommonDaoTest extends SpringDemoJdbctemplateApplicationTest {
    @Autowired
    private CommonDao commonDao;

    @Test
    public void findById() {
        List<GoodsSpu> byId = commonDao.findById("10034050");
        System.out.println(byId);
    }
}