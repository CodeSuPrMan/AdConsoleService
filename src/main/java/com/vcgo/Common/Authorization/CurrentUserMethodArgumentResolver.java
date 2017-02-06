package com.vcgo.Common.Authorization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.vcgo.Common.Globle.Constants;
import com.vcgo.Common.Globle.Globle;
import com.vcgo.Entity.VcSysLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.json.Json;
import java.io.Serializable;

/**
 * Created by 33469 on 2016/12/22.
 */

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private RedisTemplate redis;
    @Autowired
    public  void setRedis(RedisTemplate redis){
        this.redis=redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }
    public boolean supportsParameter(MethodParameter methodParameter) {
        //如果参数类型是User并且有CurrentUser注解则支持
            if(methodParameter.hasParameterAnnotation(CurrentUser.class)&&methodParameter.getParameterType().isAssignableFrom(VcSysLoginUser.class)){
            return  true;
        }
        return  false;
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object curUserId= Globle.getInstance().getThreadParams("curUserId");
        if(curUserId==null){
            throw  new MissingServletRequestPartException(Constants.CURRENT_USER);
        }
        VcSysLoginUser curUser = JSON.parseObject(redis.boundValueOps(Constants.CURRENT_USER + "-" + Integer.parseInt(curUserId.toString())).get().toString(), VcSysLoginUser.class);
        if(curUser==null){
            throw  new MissingServletRequestPartException(Constants.CURRENT_USER);
        }
        return curUser;

    }
}
