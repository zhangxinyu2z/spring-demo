package com.z2xinyu.mvc.mybatis.service.impl;

import com.z2xinyu.mvc.mybatis.dao.ItemsMapper;
import com.z2xinyu.mvc.mybatis.po.Items;
import com.z2xinyu.mvc.mybatis.service.ItemsService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Arnoer
 * @since 2022/10/8 13:53
 */
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> findAll() {
        List<Items> items = itemsMapper.selectAll();
        return CollectionUtils.isEmpty(items) ? Collections.emptyList() : items;
    }

    @Override
    public Items queryItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItems(Items items) {
        itemsMapper.updateByPrimaryKey(items);
    }
}
