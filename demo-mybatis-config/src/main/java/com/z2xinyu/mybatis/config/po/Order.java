package com.z2xinyu.mybatis.config.po;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private String number;

    private Date createtime;

    private String note;

    /** 1个订单对应1个用户*/
    private User user;
}