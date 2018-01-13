package com.hmys.frame.core.dao;

import com.hmys.frame.core.constants.SqlId;
import com.hmys.frame.core.exception.DaoException;
import com.hmys.frame.core.utils.BeanUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDaoImpl implements BaseDao {
    @Autowired(required = true)
    protected SqlSession sqlSession;

    public static final String SQLNAME_SEPARATOR = ".";

    /**
     * 获取命名空间
     * @param clazz
     * @return
     */
    protected String getNamespace(Class clazz){
        String className = clazz.getName();
        if(className.indexOf("vo") > 0)
            return clazz.getSuperclass().getName();
        return className;
    }

    /**
     * 获取sqlName
     * @param clazz
     * @param sqlId
     * @return
     */
    protected String getSqlName(Class clazz, String sqlId){
        String namespace = getNamespace(clazz);
        return namespace + SQLNAME_SEPARATOR + sqlId;
    }

    @Override
    public <T> T load(Class<T> clazz, Long id) {
        String sqlName = getSqlName(clazz, SqlId.SQL_LOAD);
        try {
            return sqlSession.selectOne(sqlName, id);
        } catch (Exception e) {
            throw new DaoException(String.format("根据ID查询对象出错！语句：%s", sqlName),
                    e);
        }
    }

    @Override
    public <T> T loadEqual(Class<T> namespace, T query) {
        String sqlName = getSqlName(namespace, SqlId.SQL_LOAD_EQUAL);
        try {
            return sqlSession.selectOne(sqlName, query);
        } catch (Exception e) {
            throw new DaoException(String.format("查询一条记录出错！语句：%s", sqlName),
                    e);
        }
    }

    @Override
    public <T> T loadEqual(Class<T> namespace, String sqlId, T query) {
        String sqlName = getSqlName(namespace, sqlId);
        try {
            return sqlSession.selectOne(sqlName, query);
        } catch (Exception e) {
            throw new DaoException(String.format("查询一条记录出错！语句：%s", sqlName),
                    e);
        }
    }

    @Override
    public <T> boolean exist(Class<T> namespace, T query) {
        String sqlName = getSqlName(namespace, SqlId.SQL_EXIST);
        boolean exist = false;
        try {
            if (query instanceof Map) {
                HashMap<String, Object> result = sqlSession.selectOne(sqlName, query);
                Long nums = (Long)result.get("nums");
                if (nums > 0)
                    exist = true;
            } else {
                Map<String, Object> params = BeanUtils.toMap(query);
                HashMap<String, Object> result = sqlSession.selectOne(sqlName, params);
                Long nums = (Long)result.get("nums");
                if (nums > 0)
                    exist = true;
            }
        } catch (Exception e) {
            throw new DaoException(
                    String.format("判断记录是否存在失败！语句:%s", sqlName), e);
        }
        return exist;
    }

    @Override
    public <T> List<T> getPageList(String sqlName, T query) {
        try {
            if (query instanceof Map) {
                return sqlSession.selectList(sqlName, query);
            } else {
                Map<String, Object> params = BeanUtils.toMap(query);
                return sqlSession.selectList(sqlName, params);
            }
        } catch (Exception e) {
            throw new DaoException(
                    String.format("根据分页对象查询列表出错！语句:%s", sqlName), e);
        }
    }

    @Override
    public <T> List<T> getPageList(Class<T> namespace, Object query) {
        String sqlName = getSqlName(namespace, SqlId.SQL_SELECT_LIST);
        try {
            if (query instanceof Map || query instanceof Long) {
                return sqlSession.selectList(sqlName, query);
            } else {
                Map<String, Object> params = BeanUtils.toMap(query);
                return sqlSession.selectList(sqlName, params);
            }
        } catch (Exception e) {
            throw new DaoException(
                    String.format("根据分页对象查询列表出错！语句:%s", sqlName), e);
        }
    }

    @Override
    public <T> List<T> getPageList(Class<T> namespace,String sqlId, Object query) {
        String sqlName = getSqlName(namespace, sqlId);
        try {
            if (query instanceof Map || query instanceof Long) {
                return sqlSession.selectList(sqlName, query);
            } else {
                Map<String, Object> params = BeanUtils.toMap(query);
                return sqlSession.selectList(sqlName, params);
            }
        } catch (Exception e) {
            throw new DaoException(
                    String.format("根据分页对象查询列表出错！语句:%s", sqlName), e);
        }
    }
}
