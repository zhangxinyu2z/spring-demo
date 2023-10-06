package com.z2xinyu.jdbctemplate.service;

import com.z2xinyu.jdbctemplate.SpringDemoJdbctemplateApplicationAnnTest;
import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
public class GoodsSpuServiceTest extends SpringDemoJdbctemplateApplicationAnnTest {
    @Autowired
    private GoodsSpuService goodsSpuService;

    @Test
    public void batchUpdateGoodsSpu() {
        ArrayList<GoodsSpu> goodsSpus = new ArrayList<>();
        GoodsSpu goodsSpu1 = new GoodsSpu();
        goodsSpu1.setId("10034050");
        goodsSpu1.setName("王屋山是太行");
        goodsSpus.add(goodsSpu1);

        GoodsSpu goodsSpu = new GoodsSpu();
        goodsSpu.setId("10034482");
        goodsSpu.setName("祖国和谐");
        goodsSpus.add(goodsSpu);

        goodsSpuService.batchUpdateGoodsSpu(goodsSpus);
    }
}