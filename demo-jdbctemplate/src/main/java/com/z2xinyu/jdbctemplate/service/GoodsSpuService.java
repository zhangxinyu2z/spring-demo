package com.z2xinyu.jdbctemplate.service;

import com.z2xinyu.jdbctemplate.dao.GoodsSpuDao;
import com.z2xinyu.jdbctemplate.po.GoodsSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
@Service
public class GoodsSpuService {
    @Autowired
    private GoodsSpuDao goodsSpuDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void batchUpdateGoodsSpu(List<GoodsSpu> goodsSpuList) {
        // test
        goodsSpuDao.updateGoodsSpu(goodsSpuList.get(0));

        // int result = 1 / 0;

        goodsSpuDao.updateGoodsSpu(goodsSpuList.get(1));

    }
}
