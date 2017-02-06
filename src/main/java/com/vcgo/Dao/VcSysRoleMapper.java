package com.vcgo.Dao;

import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Entity.VcSysRole;

import java.util.List;
import java.util.Map;

public interface VcSysRoleMapper extends  VcBaseMapper<VcSysRole>{
     int deleteRolePowerItems(int roleId);

     int insertRolePowerItems(Map<String,Object> rolePowerItems);

     List<VcSysPoweritem> selectRolePowerItems(int roleid);

     List<VcSysPoweritem> selectRolesPowerItems(Map<String,Object> prams);
}