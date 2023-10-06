package com.z2xinyu.mybatis.mapper;

import com.z2xinyu.mybatis.SpringDemoMybatisApplicationTest;
import com.z2xinyu.mybatis.po.GoodsSpu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
public class GoodsSpuMapperTest extends SpringDemoMybatisApplicationTest {

    @Autowired
    private GoodsSpuMapper goodsSpuMapper;

    @Test
    public void queryAllGoodsSpuList() {
        List<GoodsSpu> goodsSpus = goodsSpuMapper.queryAllGoodsSpuList();
        System.out.println(goodsSpus);
    }
}