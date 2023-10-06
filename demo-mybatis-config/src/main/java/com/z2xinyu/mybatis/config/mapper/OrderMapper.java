package com.z2xinyu.mybatis.config.mapper;

import com.z2xinyu.mybatis.config.po.Order;
import com.z2xinyu.mybatis.config.util.OrderProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface OrderMapper {

    void insert(Order order);

    List<Order> findByUserId(Integer uid);

    /**
     * 查询所有的Orders
     *
     * @return
     */
    List<Order> queryAllOrder();

    /**
     * 多表联合查询，1对1关系
     *
     * @return
     */
    List<Order> selectAllOrder();

    int update(Order order);

    /**
     * 动态sql的实现: https://www.cnblogs.com/EasonJim/p/7449699.html
     *
     * 当传入参数为空的时候，可能会造成全表查询
     *
     * @param order
     * @return
     */
    @Select({"<script>",
        "SELECT * FROM orders WHERE 1=1",
        "<when test='userId!=null'>",
        "AND user_id = #{userId}",
        "</when>",
        "</script>"})
    List<Order> findOrderFilter(Order order);

//    @Update("<script>
//        update Author
//        <set>
//        <if test="username != null">username=#{username},</if>
//        <if test="password != null">password=#{password},</if>
//        <if test="email != null">email=#{email},</if>
//        <if test="bio != null">bio=#{bio}</if>
//        </set>
//        where id=#{id}
//        </script>")

    @SelectProvider(type = OrderProvider.class, method = "queryOrderByParam")
    List<Order> queryOrderByParam(Order param);
}
