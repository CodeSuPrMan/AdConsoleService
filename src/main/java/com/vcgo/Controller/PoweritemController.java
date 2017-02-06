package com.vcgo.Controller;

import com.vcgo.Common.Web.JsonResp;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysPoweritem;
import com.vcgo.Entity.VcSysUser;
import com.vcgo.Service.IVc_Sys_PowerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 33469 on 2016/12/11.
 */
@Controller
@RequestMapping("/poweritem/v1")
public class PoweritemController  extends  BaseController{
    @Resource
    private IVc_Sys_PowerItemService<VcSysPoweritem> vc_Sys_PowerItemService;
    @RequestMapping(value = "/menus/page",method = RequestMethod.GET)
    public  @ResponseBody
    JsonObj getMenusList(
            PageEntity<VcSysPoweritem> page,
            @JsonResp JsonObj json
    ){
        page.setParamEntity(new VcSysPoweritem());
        List<VcSysPoweritem> menusList= vc_Sys_PowerItemService.selectPageList(page);
        json.setData(menusList);
        json.setRecordCount(page.getTotalCount());
        json.setSuccess(true);
        return json;
    }
    @RequestMapping(value = "menus",method = RequestMethod.POST)
    public @ResponseBody
    JsonObj addMenu(
            @JsonResp JsonObj json,
            @RequestBody VcSysPoweritem model
    ){
        try {
            vc_Sys_PowerItemService.insert(model);
            List powerItemTree = vc_Sys_PowerItemService.selectPowerItemTree();
            json.setRecordCount(powerItemTree.size());
            json.setSuccess(true);
            json.setData(powerItemTree);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return  json;
    }
    @RequestMapping(value = "menus",method =RequestMethod.GET )
    public  @ResponseBody
    JsonObj getChilds(
            @JsonResp JsonObj json,
            Integer pid
    ){
        try {
            VcSysPoweritem model=new VcSysPoweritem();
            model.setParentid(pid);
            json.setData(vc_Sys_PowerItemService.selectByWhere(model));
            json.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return  json;
    }
@RequestMapping(value = "menuslist",method = RequestMethod.GET)
    public @ResponseBody JsonObj getMenusList(
            @JsonResp JsonObj json
    ){
        List powerItemTree = vc_Sys_PowerItemService.selectPowerItemTree();
        json.setRecordCount(powerItemTree.size());
        json.setSuccess(true);
        json.setData(powerItemTree);
        return  json;
    }
    @RequestMapping(value = "menus/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody JsonObj deleteMenu(
            @JsonResp JsonObj json,
            @PathVariable Integer id
    ){
        try {
            json.setSuccess(vc_Sys_PowerItemService.delete(id));
        } catch (Exception e) {
            json.setSuccess(false);
        }
        return  json;
    }
    @RequestMapping(value = "menus/{id}",method = RequestMethod.PUT)
    public  @ResponseBody JsonObj updateMenus(
            @JsonResp JsonObj json,
            @RequestBody VcSysPoweritem model
    ){
        try {
            vc_Sys_PowerItemService.update(model);
            json.setSuccess(true);

        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return  json;
    }

}
