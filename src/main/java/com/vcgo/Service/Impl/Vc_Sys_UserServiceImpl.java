package com.vcgo.Service.Impl;

import com.vcgo.Dao.VcBaseMapper;
import com.vcgo.Dao.VcSysUserMapper;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysLoginUser;
import com.vcgo.Entity.VcSysUser;
import com.vcgo.Service.IVc_Sys_UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by 33469 on 2016/12/14.
 */
@Service

public class Vc_Sys_UserServiceImpl extends BaseServiceImpl<VcSysUser> implements IVc_Sys_UserService<VcSysUser> {
    @Autowired
    private VcSysUserMapper vcSysUserMapper;

    public  VcSysUser getByUP(String userName,String passWord) throws  Exception{
        Map<String,String> UP=new HashMap<String, String>();
        UP.put("username",userName);
        UP.put("password",passWord);
        VcSysUser vcSysUser = vcSysUserMapper.selectByUp(UP);
        vcSysUser.setRoleList(vcSysUserMapper.selectUserRoles(vcSysUser.getId()));
        return   vcSysUser;
    }

    public List<VcSysUser> selectPageList(PageEntity<VcSysUser> pageEntity) {
        pageEntity.setTotalCount(vcSysUserMapper.selectCount(pageEntity));
        if(pageEntity.getCurrentPage()<1){
            return new ArrayList<VcSysUser>();
        }
       return   vcSysUserMapper.selectPageList(pageEntity);
    }

    protected VcBaseMapper<VcSysUser> setCurrentDao() {
        return  vcSysUserMapper;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public  VcSysUser update(VcSysUser entity){
        vcSysUserMapper.update(entity);
        vcSysUserMapper.deleteUserRoles(entity.getId());
        if(entity.getRoleIds().size()>0){
            Map<String,Object> userRoles=new HashMap<String, Object>();
            userRoles.put("userRoleIds",entity.getRoleIds());
            userRoles.put("userId",entity.getId());
            vcSysUserMapper.insertUserRoles(userRoles);
        }
        return  selectByID(entity.getId());
    }

    @Override
    public VcSysUser selectByID(int id){
        VcSysUser user = super.selectByID(id);
        user.setRoleList(vcSysUserMapper.selectUserRoles(id));
        return user;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean delete(int id){
        vcSysUserMapper.deleteUserRoles(id);
        return super.delete(id);
    }
}
