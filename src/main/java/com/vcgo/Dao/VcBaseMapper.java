package com.vcgo.Dao;

import com.vcgo.Entity.PageEntity;

import java.util.List;

/**
 * Created by 33469 on 2016/12/12.
 */
public interface VcBaseMapper<T> {

    void insert(T entity);

    int update(T entity);

    int delete(int id);

    int deleteByWhere(T entity);

    T selectById(int id);

    T selectByWhere(T entity);

    List<T> selectList(T entity);

    List<T> selectPageList(PageEntity<T> pageEntity);

    int selectCount(PageEntity<T> pageEntity);
}
