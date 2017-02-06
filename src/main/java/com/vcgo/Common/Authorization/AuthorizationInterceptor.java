package com.vcgo.Common.Authorization;

import com.vcgo.Common.Globle.Constants;
import com.vcgo.Common.Globle.Globle;
import com.vcgo.Entity.VcSysToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**身份验证拦截器
 * @author Vicwu
 *
 */

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenManager tokenManager;

    /**
     * 鉴权
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return  true;
        }
        if(!((HandlerMethod) handler).hasMethodAnnotation(Authorization.class)){
            return  true;
        }
        final   Cookie[] cookies = request.getCookies();
        String authorization= StringUtils.EMPTY;
        if(cookies!=null){
            for (final Cookie cookie:
                    cookies){
                final String cookieName=cookie.getName();
                if(cookieName.equals(Constants.AUTHORIZATION)){
                    authorization=cookie.getValue();
                    break;
                }
            }
            if(StringUtils.isEmpty(authorization)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return  false;
            }
            final String[] authArr=authorization.split("_");
            final Long userId=Long.parseLong(authArr[0]);
            Globle.getInstance().setThreadParams("curUserId",userId);
            final String tokenStr=authArr[1];
            VcSysToken token=new VcSysToken(userId,tokenStr);
            if(!tokenManager.checkToken(token)){
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return  false;
            }
        }
        return true;
    }
}
