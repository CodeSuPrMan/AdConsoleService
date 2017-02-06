package com.vcgo.Dao;

import com.vcgo.Entity.VcSysRole;
import com.vcgo.Entity.VcSysUser;
import com.vcgo.Entity.VcSysUserRole;

import java.util.List;
import java.util.Map;

public interface VcSysUserMapper extends  VcBaseMapper<VcSysUser>{

      VcSysUser selectByUp(Map<String,String> UP);
      int deleteUserRoles (int id);
      int insertUserRoles(Map<String,Object> userRoles);
      List<VcSysUserRole> selectUserRoleRef(VcSysUserRole model);
      List<VcSysRole> selectUserRoles(int userId);


}