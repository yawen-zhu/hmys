package com.hmys.frame.core.service;

import java.util.List;

public interface BaseService {

    /**
     * 查询一条记录
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    public <T> T load(Class<T> clazz, Long id);

    /**
     * 查询一条记录
     * @param clazz
     * @param query
     * @param <T>
     * @return
     */
    public <T> T loadEqual(Class<T> clazz, T query);

    /**
     * 查询一条记录
     * @param clazz
     * @param sqlName
     * @param query
     * @param <T>
     * @return
     */
    public <T> T loadEqual(Class<T> clazz, String sqlName, T query);

    /**
     * 判断记录是否存在
     * @param clazz
     * @param query
     * @param <T>
     * @return
     */
    public <T> boolean exist(Class<T> clazz, T query);

    /**
     * 列表查询
     * 根据sqlId全路径名和参数查询
     * @param sqlName
     * @param query
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(String sqlName, T query);

    /**
     * 列表查询
     * 根据命名空间和参数查询，sqlId默认SqlId.SQL_SELECT_LIST
     * @param clazz
     * @param query
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(Class<T> clazz, Object query);

    /**
     * 列表查询
     * 根据命名空间和sqlId以及参数查询
     * @param clazz
     * @param sqlName
     * @param query
     * @param <T>
     * @return
     */
    public <T> List<T> getPageList(Class<T> clazz, String sqlName,  Object query);
}
