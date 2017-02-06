package com.vcgo.Service.Impl;

import com.vcgo.Dao.VcBaseMapper;
import com.vcgo.Entity.BaseEntity;
import com.vcgo.Entity.PageEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 33469 on 2017/2/2.
 */
public abstract   class BaseServiceImpl<T extends BaseEntity>  {

    protected VcBaseMapper baseMapper;

    protected abstract VcBaseMapper<T> setCurrentDao();


    public T insert(T entity) {
        if(baseMapper==null){
            baseMapper=setCurrentDao();
        }
        entity.setCreatedate(new Date());
        entity.setEditdate(new Date());
        baseMapper.insert(entity);
        return entity;
    }

    public T update(T entity) {
        if(baseMapper==null){
            baseMapper=setCurrentDao();
        }
        entity.setEditdate(new Date());
        baseMapper.update(entity);
        return (T)baseMapper.selectById(entity.getId());
    }

    public List<T> selectPageList(PageEntity<T> pageEntity) {
        if(baseMapper==null){
            baseMapper=setCurrentDao();
        }
        pageEntity.setTotalCount(baseMapper.selectCount(pageEntity));
        if(pageEntity.getTotalCount()<1){
            return  new ArrayList<T>();
        }
        return baseMapper.selectPageList(pageEntity);
    }

    public boolean delete(int pk) {
        if(baseMapper==null){
            baseMapper=setCurrentDao();
        }
        return  baseMapper.delete(pk)>0;
    }

    public T selectByID(int id) {
        if(baseMapper==null){
            baseMapper=setCurrentDao();
        }
        return (T)baseMapper.selectById(id);
    }

}
