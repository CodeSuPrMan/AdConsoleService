package com.vcgo.Controller;

import com.vcgo.Common.Web.JsonResp;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysRole;
import com.vcgo.Service.IVc_Sys_RoleService;
import com.vcgo.Service.IVc_Sys_UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 33469 on 2016/12/2.
 */
@Controller
@RequestMapping("/role/v1/")
public class RoleController  extends BaseController{
    @Autowired
    private IVc_Sys_RoleService roleService;
    @RequestMapping(value = "roles",method = RequestMethod.GET)
    public @ResponseBody
    JsonObj pageList(
            @JsonResp JsonObj json,
            PageEntity<VcSysRole> pageEntity
    ){
       return super.listPage(pageEntity,json,roleService);
    }
    @RequestMapping(value = "roles",method = RequestMethod.POST)
    public @ResponseBody JsonObj addRole(
            @JsonResp JsonObj json,
            @RequestBody VcSysRole model
    ) {
       //roleService.insert(model);
        return add(model,json,roleService);
    }
    @RequestMapping(value = "roles/{id}",method = RequestMethod.DELETE)
    public @ResponseBody JsonObj deleteRole(
            @JsonResp JsonObj json,
            @PathVariable Integer id
    ){
        try {
            roleService.delete(id);
            json.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setMessage(e.getMessage());
            json.setSuccess(false);
        }
        return  json;
    }
    @RequestMapping(value = "roles",method = RequestMethod.PUT)
    public  @ResponseBody JsonObj updateRole(
            @JsonResp JsonObj json,
            @RequestBody VcSysRole model
    ){
        try {
            VcSysRole role = roleService.update(model);
            json.setData(role);
            json.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
        }
        return  json;
    }
    @RequestMapping(value = "roles/{id}",method = RequestMethod.GET)
    public  @ResponseBody JsonObj getRoleByID(
            @JsonResp JsonObj json,
            @PathVariable Integer id
    ){
        try {
            VcSysRole role = roleService.selectByID(id);
            json.setData(role);
            json.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return json;
    }
}
