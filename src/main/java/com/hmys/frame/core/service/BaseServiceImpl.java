package com.hmys.frame.core.service;

import com.hmys.frame.core.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseServiceImpl implements BaseService {
    /**
     * 获取基础数据库操作类
     * @return
     */
    protected abstract BaseDao getBaseDao();

    @Override
    public <T> List<T> getPageList(String sqlName, T query) {
        return getBaseDao().getPageList(sqlName, query);
    }

    @Override
    public <T> T load(Class<T> clazz, Long id) {
        return getBaseDao().load(clazz, id);
    }

    @Override
    public <T> boolean exist(Class<T> clazz, T query) {
        return getBaseDao().exist(clazz, query);
    }

    @Override
    public <T> T loadEqual(Class<T> clazz, T query) {
        return getBaseDao().loadEqual(clazz, query);
    }

    @Override
    public <T> T loadEqual(Class<T> clazz, String sqlName, T query) {
        return getBaseDao().loadEqual(clazz, sqlName, query);
    }

    @Override
    public <T> List<T> getPageList(Class<T> clazz, Object query) {
        
        return getBaseDao().getPageList(clazz, query);
    }

    @Override
    public <T> List<T> getPageList(Class<T> clazz, String sqlName, Object query) {
        return getBaseDao().getPageList(clazz, sqlName, query);
    }

}
