package com.z2xinyu.mybatis.dao;

import com.z2xinyu.mybatis.po.GoodsSpu;

import java.util.List;

/**
 * @author dhjy
 * @version v1.0
 * @date created in 2021-05-20 20:44
 */
public interface GoodsSpuDao {
    /**
     * 通过用户id查询用户信息

     * @return
     */
    List<GoodsSpu> queryAllGoodsSpuList();
}
