package com.z2xinyu.jdbctemplate.po;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhangxinyu
 * @date 2023/7/6
 **/
@Data
public class GoodsSpu {
    /*
    create table goods_spu
(
    ID            varchar(32)  not null
        primary key ,
    SELLER_ID     varchar(32)  null ,
    CATEGORY_ID1  varchar(32)  null ,
    CATEGORY_ID2  varchar(32)  null ,
    CATEGORY_ID3  varchar(32)  null ,
    NAME          varchar(500) null ,
    GOODS_STATE   int          null ,
    MAIN_IMAGE_ID varchar(500) null
);
     */
    private String id;
    private String sellerId;
    private String categoryId;
    private String categoryId2;
    private String categoryId3;
    private String name;
    private Integer goodsState;
    private String mainLangId;
}
