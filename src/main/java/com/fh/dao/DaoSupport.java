package com.fh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("daoSupport")
public class DaoSupport implements DAO {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public Object save(String str, Object obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    public Object batchSave(String str, Object... obj) {
        return sqlSessionTemplate.insert(str, obj);
    }

    public Object update(String str, Object obj) {
        return sqlSessionTemplate.update(str, obj);
    }

    public void batchUpdate(String str, List<Object> objs) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        //批量执行器
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try {
            if (objs != null) {
                for (int i = 0, size = objs.size(); i < size; i++) {
                    sqlSession.update(str, objs.get(i));
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        } finally {
            sqlSession.close();
        }
    }

    public Object batchDelete(String str, Object... obj) {
        return sqlSessionTemplate.delete(str, obj);
    }

    public Object delete(String str, Object obj) {
        return sqlSessionTemplate.delete(str, obj);
    }

    public Object findForObject(String str, Object obj) {
        return sqlSessionTemplate.selectOne(str, obj);
    }

    public Object findForList(String str, Object obj) {
        return sqlSessionTemplate.selectList(str, obj);
    }

    public Object findForMap(String str, Object obj, String key, String value) {
        return sqlSessionTemplate.selectMap(str, obj, key);
    }

}


