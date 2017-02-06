package com.vcgo.Dao;

import com.vcgo.Entity.VcSysPoweritem;

import java.util.List;


public  interface VcSysPoweritemMapper  extends VcBaseMapper<VcSysPoweritem> {
    VcSysPoweritem selectByWhere(VcSysPoweritem model);
}