package com.z2xinyu.mybatis.mapper;

import com.z2xinyu.mybatis.po.GoodsSpu;

import java.util.List;

/**
 * @author dhjy
 * @version v1.0
 * @date created in 2021-05-20 22:42
 */
public interface GoodsSpuMapper {
    /**
     * 查询所有的用户信息
     *
     * @return
     */
    List<GoodsSpu> queryAllGoodsSpuList();
}
