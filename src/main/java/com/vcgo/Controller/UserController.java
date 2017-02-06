package com.vcgo.Controller;

import com.vcgo.Common.Web.JsonResp;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysUser;
import com.vcgo.Service.IVc_Sys_UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 33469 on 2016/12/14.
 */
@Controller
@RequestMapping("/user/v1")
public class UserController extends BaseController {

    public  UserController(){
        System.out.println("UserController初始化");
    }


    @Resource
    public IVc_Sys_UserService<VcSysUser> vc_sys_userService;


    @RequestMapping(value = "/users",method =RequestMethod.GET)
    public @ResponseBody
    JsonObj getUserList(
            PageEntity<VcSysUser> page,
            @JsonResp JsonObj json
    ){
        page.setParamEntity(new VcSysUser());
        List<VcSysUser> userList= vc_sys_userService.selectPageList(page);
        json.setData(userList);
        json.setRecordCount(page.getTotalCount());
        json.setSuccess(true);
        return json;
    }
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public @ResponseBody
    JsonObj  addUser(
            @RequestBody VcSysUser model,
            @JsonResp JsonObj json
        ){
        try {
            vc_sys_userService.insert(model);
            PageEntity<VcSysUser> page=new PageEntity<VcSysUser>();
            page.setCurrentPage(1);
            page.setPageSize(20);
            List<VcSysUser> userList= vc_sys_userService.selectPageList(page);
            json.setData(userList);
            json.setSuccess(true);
            json.setRecordCount(page.getTotalCount());
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return json;
    }
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public  @ResponseBody
    JsonObj updateUser(
//            @PathVariable Integer id,
             @RequestBody  VcSysUser model,

             @JsonResp JsonObj json
             ){
        try {
            VcSysUser newModel=  vc_sys_userService.update(model);
            json.setSuccess(true);
            json.setData(newModel);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return  json;
    }
@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public  @ResponseBody
    JsonObj deleteUser(
            @PathVariable int id,
            @JsonResp JsonObj json
        ) {
    try {
        vc_sys_userService.delete(id);
        json.setSuccess(true);
    } catch (Exception e) {
        e.printStackTrace();
        json.setSuccess(false);
        json.setMessage(e.getMessage());
    }
    return  json;
}
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public  @ResponseBody
    JsonObj getUserByID(
            @PathVariable int id,
            @JsonResp JsonObj json
            ){
        try {
            VcSysUser model=   vc_sys_userService.selectByID(id);
            json.setData(model);
            json.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setMessage(e.getMessage());
        }
        return  json;
    }

}














