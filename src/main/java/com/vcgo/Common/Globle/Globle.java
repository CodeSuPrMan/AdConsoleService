package com.vcgo.Common.Globle;

import com.google.common.collect.MapConstraint;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 33469 on 2016/12/16.
 */
public  class Globle {


    /**
     * 全局实例
     */
    private  static final Globle globle=new Globle();
    /**
     * 保存全局属性值
     */
      static  final   Map<String,String> map= Maps.newHashMap();

    /**
     * 获取全局变量实例
     * @return Globle
     */
    public  static Globle getInstance(){
        return  globle;
    }

    /**
     * 保存线程内变量
     */

    private static   final ThreadLocal<HashMap<String,Object>> threadParams=new ThreadLocal<HashMap<String, Object>>();

    public void setThreadParams(String key,Object value){
         if(threadParams.get()==null){
             threadParams.set(new HashMap<String,Object>());
         }
        threadParams.get().put(key,value);
    }
    public Object getThreadParams(String key){
        if(threadParams.get()==null){
            return  null;
        }
       return threadParams.get().get(key);
    }

}
