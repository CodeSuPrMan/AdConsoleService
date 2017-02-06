package com.vcgo.Service;

import com.vcgo.Entity.VcSysPoweritem;

import java.util.List;

/**
 * Created by 33469 on 2016/12/11.
 */
public interface IVc_Sys_PowerItemService<T> extends IVc_BaseService<T> {
    public List<VcSysPoweritem> selectByWhere(VcSysPoweritem model);


    public  List<VcSysPoweritem> selectPowerItemTree();
}
