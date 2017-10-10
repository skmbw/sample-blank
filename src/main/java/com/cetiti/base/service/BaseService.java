package com.cetiti.base.service;

import com.cetiti.base.dao.BaseDao;

import java.io.Serializable;
import java.util.List;

/**
 * MyBatis通用泛型Service实现，简化service的实现。去掉了QBE查询。
 *
 * @author yinlei
 * @since 2017-9-30 11:02
 * @param <T> 泛型实体类
 * @param <ID> 主键类型
 */
public abstract class BaseService<T, ID extends Serializable> {

    protected BaseDao<T, ID> baseDao;

    /**
     * 设置具体的Dao实例。
     * @param baseDao 具体的Dao实例
     */
    public abstract void setBaseDao(BaseDao<T, ID> baseDao);

    public int countBy(T params) {
        return baseDao.countBy(params);
    }

    public int deleteBulks(T params) {
        return baseDao.deleteBulks(params);
    }

    public int deleteById(ID id) {
        return baseDao.deleteById(id);
    }

    public int save(T record) {
        return baseDao.save(record);
    }

    public List<T> queryList(T params) {
        return baseDao.queryList(params);
    }

    public List<T> pagedList(T params) {
        return baseDao.pagedList(params);
    }

    public T get(ID id) {
        return baseDao.get(id);
    }

    public T getForUpdate(ID id) {
        return baseDao.getForUpdate(id);
    }

    public T unique(T params) {
        return baseDao.unique(params);
    }

    public T uniqueForUpdate(T params) {
        return baseDao.uniqueForUpdate(params);
    }

    public int updateBulks(T record, T params) {
        return baseDao.updateBulks(record, params);
    }

    public int updateById(T record) {
        return baseDao.updateById(record);
    }

}
