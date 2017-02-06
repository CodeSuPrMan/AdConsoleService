package com.vcgo.Service;

import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysUser;

import java.util.List;
import java.util.Map;

public interface IVc_Sys_UserService<T> extends IVc_BaseService<T>{

    VcSysUser getByUP(String userName,String passWord) throws Exception;

}
