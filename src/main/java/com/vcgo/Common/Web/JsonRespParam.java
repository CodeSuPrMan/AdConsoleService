package com.vcgo.Common.Web;

import com.vcgo.Entity.JsonObj;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by 33469 on 2017/1/17.
 */
public class JsonRespParam implements HandlerMethodArgumentResolver {
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.getParameterType().isAssignableFrom(JsonObj.class)&& methodParameter.hasParameterAnnotation(JsonResp.class)){
            return  true;
        }
        return false;
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return new JsonObj();
    }
}
