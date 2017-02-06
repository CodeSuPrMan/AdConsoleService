package com.vcgo.Service;

import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysUser;

import java.util.List;

/**
 * Created by 33469 on 2016/12/14.
 */
public interface IVc_BaseService<T> {
    T insert(T entity);

    T update(T entity);

    List<T> selectPageList(PageEntity<T> pageEntity);

    boolean delete(int pk);

    T selectByID(int id);
}
