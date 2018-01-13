package com.hmys.frame.core.dao;

import java.util.List;

public interface BaseDao {

    /**
     * 根据条件查询一条记录
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    public <T> T load(Class<T> clazz, Long id);

    /**
     * 查询一条记录(根据默认的SQLID)
     * @param clazz
     * @param query
     * @param <T>
     * @return
     */
    public <T> T loadEqual(Class<T> clazz, T query);

    /**
     * 查询一条记录(根据传入的SQLID)
     * @param clazz
     * @param sqlName
     * @param query
     * @param <T>
     * @return
     */
    public <T> T loadEqual(Class<T> clazz, String sqlName, T query);

    /**
     * 根据条件查询记录是否存在
     * @param clazz
     * @param query
     * @param <T>
     * @return
     */
    public <T> boolean exist(Class<T> clazz, T query);

    /**
     * 获取分页的列表数据
     * @param sqlName 包含mapper命名空间和sqlId
     * @param query   参数对象
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(String sqlName, T query);

    /**
     * 获取分页的列表数据
     * 默认sqlId为SqlId.SQL_SELECT_LIST
     * @param clazz 命名空间
     * @param param     参数对象
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(Class<T> clazz, Object param);

    /**
     * 获取分页的列表数据
     * @param sqlName 命名空间
     * @param sqlId  sqlId
     * @param param 参数对象
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(Class<T> sqlName,String sqlId, Object param);
}
