package com.z2xinyu.mybatis.dao;

import com.z2xinyu.mybatis.po.GoodsSpu;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * sqlSessionDaoSupport实现了setSqlSessionFactory()
 */
public class GoodsSpuDaoImpl extends SqlSessionDaoSupport implements GoodsSpuDao {

    @Override
    public List<GoodsSpu> queryAllGoodsSpuList() {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectList("queryAllGoodsSpuList");
    }
}
