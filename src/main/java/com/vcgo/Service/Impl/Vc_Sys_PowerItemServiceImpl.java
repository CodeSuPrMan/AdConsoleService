package com.vcgo.Service.Impl;

import com.vcgo.Common.Globle.Utils;
import com.vcgo.Dao.VcSysPoweritemMapper;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Service.IVc_Sys_PowerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 33469 on 2017/1/26.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class Vc_Sys_PowerItemServiceImpl implements IVc_Sys_PowerItemService<VcSysPoweritem> {
    @Autowired
    private VcSysPoweritemMapper vcSysPoweritemMapper;

    public VcSysPoweritem insert(VcSysPoweritem model) {
        model.setCreatedate(new Date());
        vcSysPoweritemMapper.insert(model);
        return model;
    }

    public List<VcSysPoweritem> selectPageList(PageEntity<VcSysPoweritem> pageEntity) {
        pageEntity.setTotalCount(vcSysPoweritemMapper.selectCount(pageEntity));

        if(pageEntity.getTotalCount()<1){
            return  new ArrayList<VcSysPoweritem>();
        }
        return vcSysPoweritemMapper.selectPageList(pageEntity);
    }

    public boolean delete(int pk) {
        return  vcSysPoweritemMapper.delete(pk)>0;
    }

    public VcSysPoweritem selectByID(int id) {
        return null;
    }

    public VcSysPoweritem getPoweritemById(int poweritemId) {
        return null;
    }

    public List<VcSysPoweritem> selectByWhere(VcSysPoweritem model) {
        return  null;
    }

    public List<VcSysPoweritem> selectPowerItemTree() {
       List<VcSysPoweritem> allList= vcSysPoweritemMapper.selectList(new VcSysPoweritem());
        List<VcSysPoweritem> list= Utils.fillTreeEntity(allList);
        return  list;
    }

    public VcSysPoweritem update(VcSysPoweritem model){
        vcSysPoweritemMapper.update(model);
        return  vcSysPoweritemMapper.selectById(model.getId());
    }

}
