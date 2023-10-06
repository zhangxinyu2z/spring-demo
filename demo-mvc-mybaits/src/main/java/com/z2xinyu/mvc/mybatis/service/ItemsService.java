package com.z2xinyu.mvc.mybatis.service;

import com.z2xinyu.mvc.mybatis.po.Items;

import java.util.List;

/**
 * @author Arnoer
 * @since 2022/10/8 13:52
 */
public interface ItemsService {
    List<Items> findAll();

    Items queryItemsById(Integer id);

    void updateItems(Items items);
}
