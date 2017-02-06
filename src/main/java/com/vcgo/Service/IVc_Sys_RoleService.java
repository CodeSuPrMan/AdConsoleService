package com.vcgo.Service;

import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Entity.VcSysRole;

import java.util.List;
import java.util.Map;

/**
 * Created by 33469 on 2017/2/2.
 */
public interface IVc_Sys_RoleService extends  IVc_BaseService<VcSysRole>{
    List<VcSysPoweritem> selectRolesPowerItems(Map<String,Object> params);
}
