package com.vcgo.Service.Impl;

import com.vcgo.Dao.VcBaseMapper;
import com.vcgo.Dao.VcSysRoleMapper;
import com.vcgo.Dao.VcSysUserMapper;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Entity.VcSysRole;
import com.vcgo.Entity.VcSysUserRole;
import com.vcgo.Service.IVc_Sys_RoleService;
import org.apache.ibatis.ognl.IntHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 33469 on 2017/2/2.
 */
@Service

public class Vc_Sys_RoleServiceImpl extends BaseServiceImpl<VcSysRole> implements IVc_Sys_RoleService {

    @Autowired
    private VcSysRoleMapper vcSysRoleMapper;
    @Autowired
    private VcSysUserMapper vcSysUserMapper;

    protected VcBaseMapper<VcSysRole> setCurrentDao() {
        return  vcSysRoleMapper;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public VcSysRole update(VcSysRole model){
        vcSysRoleMapper.deleteRolePowerItems(model.getId());
        if(model.getPoweritemids().size()>0){
            Map<String,Object> rolePowerItems=new HashMap<String,Object>();
            rolePowerItems.put("roleId",model.getId());
            rolePowerItems.put("rolePowerItems",model.getPoweritemids());
            vcSysRoleMapper.insertRolePowerItems(rolePowerItems);
        }
        return selectByID(model.getId());
    }

    @Override
    public VcSysRole selectByID(int id){
        VcSysRole role = super.selectByID(id);
        role.setRolepoweritems(vcSysRoleMapper.selectRolePowerItems(id));
        return role;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(int id){
        List<VcSysUserRole> userRoles = vcSysUserMapper.selectUserRoleRef(new VcSysUserRole(null, id));
        if(userRoles.size()>0){
            String username = vcSysUserMapper.selectById(userRoles.get(0).getUser_id()).getUsername();
            throw new RuntimeException("若要删除此角色，请先删除用户："+username);
        }
        vcSysRoleMapper.deleteRolePowerItems(id);
        return super.delete(id);
    }

    public List<VcSysPoweritem> selectRolesPowerItems(Map<String,Object> params){
       return   vcSysRoleMapper.selectRolesPowerItems(params);
    }

}
