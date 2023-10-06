package com.z2xinyu.mybatis.config.po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * pojo包装对象
 * 将pojo作为另一个pojo的属性
 */
@Data
public class QueryVo implements Serializable {

    private static final long serialVersionUID = -7799479521929818130L;
    private User user;
    private List<Integer> idList;
    private Integer[] ids;
}
