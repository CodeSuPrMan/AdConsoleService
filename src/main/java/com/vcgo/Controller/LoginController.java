package com.vcgo.Controller;

import com.alibaba.fastjson.JSON;
import com.vcgo.Common.Authorization.Authorization;
import com.vcgo.Common.Authorization.CurrentUser;
import com.vcgo.Common.Authorization.TokenManager;
import com.vcgo.Common.Globle.Constants;
import com.vcgo.Common.Web.JsonResp;
import com.vcgo.Entity.JsonObj;
import com.vcgo.Entity.VcSysLoginUser;
import com.vcgo.Entity.VcSysToken;
import com.vcgo.Entity.VcSysUser;
import com.vcgo.Service.IVc_Sys_UserService;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;


/**
 * Created by 33469 on 2016/12/14.
 */
@Controller
@RequestMapping("/login/v1")
public class LoginController extends  BaseController {
    @Autowired
    private IVc_Sys_UserService vc_sys_userService;
    @Autowired
    private TokenManager tokenManager;
    private RedisTemplate<String,Serializable> redis;
    @Autowired
    public  void setRedis(RedisTemplate redis){
        this.redis=redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    //@CrossOrigin(origins = "http://localhost:8989/")
    public  @ResponseBody
    JsonObj DoLogin(
            @RequestBody VcSysLoginUser user,
            @JsonResp JsonObj json){
        try {
            VcSysUser userEntity= vc_sys_userService.getByUP(user.getUsername(),user.getPassword());
            VcSysLoginUser loginEntity=new VcSysLoginUser();
            BeanUtils.copyProperties(userEntity,loginEntity);
            long id=userEntity.getId();
            VcSysToken vcSysToken=  tokenManager.createToken(id);
            //redis.opsForHash().put("user",Constants.CURRENT_USER,loginEntity);
            redis.boundValueOps(Constants.CURRENT_USER+"-"+id).set(JSON.toJSONString(loginEntity),Constants.TOKEN_EXPIRES_MINUTES, TimeUnit.MINUTES);
            String clientToken=vcSysToken.getUserid()+"_"+vcSysToken.getToken();
            json.setSuccess(true);
            json.setData(loginEntity);
            json.setText(clientToken);
            //this.json.setMessage();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException((e));
        }
        return  json;
    }
    @Authorization
    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public  @ResponseBody JsonObj  LoginOut(
            @JsonResp JsonObj json,
            @CurrentUser VcSysLoginUser curUser
    ){
        tokenManager.deleteToken(curUser.getId());
        json.setSuccess(true);
        return  json;
    }


}
