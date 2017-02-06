package com.vcgo.Controller;

import com.vcgo.Common.Authorization.Authorization;
import com.vcgo.Common.Authorization.CurrentUser;
import com.vcgo.Common.Web.JsonResp;
import com.vcgo.Entity.Enums.ePowerItemType;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.VcSysLoginUser;
import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Service.IVc_Sys_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 33469 on 2017/2/4.
 */
@Controller
@RequestMapping("/sys")
public class HomeController extends  BaseController {

    @Autowired
    private   IVc_Sys_RoleService vc_Sys_RoleService;


    @RequestMapping(value = "/menus",method = RequestMethod.GET)
    @Authorization
    public @ResponseBody
    JsonObj menusLoading(
            @JsonResp JsonObj json,
            @CurrentUser VcSysLoginUser curUser
    ){
        List<VcSysPoweritem> powerItems;
        if(curUser.getRoleIds().size()>0){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("RoleIdList",curUser.getRoleIds());
            map.put("ItemType", ePowerItemType.MENU);
            powerItems= vc_Sys_RoleService.selectRolesPowerItems(map);
        }else {
            powerItems=new LinkedList<VcSysPoweritem>();
        }
        json.setData(powerItems);
        json.setSuccess(true);
        return  json;
    }
    @RequestMapping(value = "user",method = RequestMethod.GET)
    @Authorization
    public  @ResponseBody
    JsonObj userLoading(
            @JsonResp JsonObj json,
            @CurrentUser VcSysLoginUser curUser
    ){
        json.setData(curUser);
        json.setSuccess(true);
        return  json;
    }
}
