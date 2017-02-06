package com.vcgo.Common.Web;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 33469 on 2016/12/16.
 */
//@Configuration
//@EnableWebMvc
//public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("**");
//        //super.addCorsMappings(registry);
//    }
//}
    @Component
public  class  CORSFilter implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponseesponse=(HttpServletResponse)response;
        HttpServletRequest httpServletRequest=(HttpServletRequest)request;
        String origin=httpServletRequest.getHeader("Origin");
        // String origin=  (String)request.getRemoteHost()+":"+request.getRemotePort();
        httpServletResponseesponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponseesponse.setHeader("Access-Control-Allow-Methods","GET,PUT,POST,OPTIONS,DELETE");
        httpServletResponseesponse.setHeader("Access-Control-Max-Age","3600");
        httpServletResponseesponse.setHeader("Access-Control-Allow-Credentials","true");
        httpServletResponseesponse.setHeader("Access-Control-Allow-Headers","Content-Type,Access-Control-Allow-Headers,Accept,X-Requested-With,Origin");

        chain.doFilter(request,response);
       // httpServletResponseesponse.setHeader();
    }

    public void destroy() {

    }
}