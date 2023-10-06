package com.z2xinyu.mybatis.dao;

import com.z2xinyu.mybatis.SpringDemoMybatisApplicationTest;
import com.z2xinyu.mybatis.po.GoodsSpu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
public class GoodsSpuDaoImplTest extends SpringDemoMybatisApplicationTest {

    @Autowired
    private GoodsSpuDaoImpl goodsSpuDao;

    @Test
    public void queryAllGoodsSpuList() {
        List<GoodsSpu> goodsSpus = goodsSpuDao.queryAllGoodsSpuList();
        System.out.println(goodsSpus);
    }
}