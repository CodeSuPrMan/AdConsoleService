package com.vcgo.Controller;

import com.vcgo.Entity.BaseEntity;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.PageEntity;
import com.vcgo.Entity.VcSysRole;
import com.vcgo.Service.IVc_BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by 33469 on 2016/12/14.
 */
@Controller
@RequestMapping("/api")
public class BaseController {
    @Resource
    ServletContext application;

    public  BaseController(){
        System.out.println("BaseController初始化");
    }

    protected JsonObj listPage(PageEntity<? extends BaseEntity> page, JsonObj json, IVc_BaseService service){
        List list=  service.selectPageList(page);
        json.setSuccess(true);
        json.setData(list);
        json.setRecordCount(page.getTotalCount());
        return  json;
    }

    protected <T extends BaseEntity> JsonObj add(T model,JsonObj json,IVc_BaseService service){
        service.insert(model);
        PageEntity<T> page=new PageEntity<T>();
        return listPage(page,json,service);
    }

}
