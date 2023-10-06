package com.z2xinyu.mvc.mybatis.po;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zxy
 * @version v1.0
 * @date created in 2021-11-29 16:44
 */
@Setter@Getter
public class QueryVo {
    private List<Items> itemsList;
    private Integer[] ids;
}
