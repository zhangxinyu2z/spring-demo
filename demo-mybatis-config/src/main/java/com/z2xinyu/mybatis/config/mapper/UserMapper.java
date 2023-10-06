package com.z2xinyu.mybatis.config.mapper;

import com.z2xinyu.mybatis.config.po.QueryVo;
import com.z2xinyu.mybatis.config.po.User;

import java.util.List;
import java.util.Map;

/**
 * Mapper的动态代理开发
 * 遵循四个原则
 * 接口 方法名  == User.xml 中 id 名
 * 返回值类型  与  Mapper.xml文件中返回值类型要一致
 * 方法的入参类型 与Mapper.xml中入参的类型要一致
 * Mapper.xml命名空间 绑定此接口
 *
 * @author dhjy
 * @version v1.0
 * @date created in 2021-05-19 20:58
 */
public interface UserMapper {
    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 根据用户名模糊查询用户信息
     *
     * @param name
     * @return
     */
    List<User> findUserByUsername(String name);

    /**
     * 根据用户名模糊查询，通过vo包装对象来查询
     *
     * @param queryVo
     * @return
     */
    List<User> queryUserByUserName(QueryVo queryVo);

    /**
     * 通过用户名和sex查找
     *
     * @param user
     * @return
     */
    List<User> queryUserBySexAndName(User user);

    /**
     * 查询在指定的id集合中的User
     *
     * @param queryVo
     * @return
     */
    List<User> queryUserByIds(QueryVo queryVo);

    /**
     * 用数组作参数
     * 用List集合做参数
     */
    List<User> queryUserByIdsOfArray(Integer[] ids);

    /**
     * 用queryvo传递值，使用内部的数组
     */
    List<User> queryUserByVoIds(QueryVo queryVo);

    /**
     * 直接传递一个list
     *
     * @param idList
     * @return
     */
    List<User> queryUserByIdsOfList(List<Integer> idList);

    /**
     * 多表联合查询，一个用户对应多张订单
     *
     * @return
     */
    List<User> queryAllUser();

    /**
     * 传递一个map
     */
    List<User> queryUserByIdsOfMap(Map<String, Integer[]> map);

    User findUserInfo(Integer id);
}
