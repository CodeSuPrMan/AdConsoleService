package com.vcgo.Common.Authorization;

import com.vcgo.Common.Globle.Constants;
import com.vcgo.Entity.VcSysToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by 33469 on 2016/12/19.
 */
@Component
public class  RedisTokenManagerImpl implements  TokenManager {

    private RedisTemplate redis;
    @Autowired
    public  void setRedis(RedisTemplate redis){
        this.redis=redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }


    public VcSysToken createToken(long userid) {
        String token= UUID.randomUUID().toString().replace("-","");
        VcSysToken tokenModel=new VcSysToken(userid,token);
        redis.boundValueOps(userid).set(token,Constants.TOKEN_EXPIRES_MINUTES, TimeUnit.MINUTES);
        return tokenModel;
    }

    public VcSysToken getToken(String authentication) {
        if(StringUtils.isEmpty(authentication)){
            return  null;
        }
        String[] autharr = authentication.split("_");
        VcSysToken vcSysToken=new VcSysToken(Long.parseLong(autharr[0]),autharr[1]);
        return vcSysToken;
    }

    public boolean checkToken(VcSysToken model) {
        if(model==null){
            return  false;
        }

        Object token=redis.boundValueOps(model.getUserid()).get();
        if (token==null) {
            return  false;
        }
        redis.boundValueOps(model.getUserid()).expire(Constants.TOKEN_EXPIRES_MINUTES,TimeUnit.MINUTES);
        redis.boundValueOps(Constants.CURRENT_USER+"-"+model.getUserid()).expire(Constants.TOKEN_EXPIRES_MINUTES,TimeUnit.MINUTES);
        return  true;

    }

    public void deleteToken(long userid) {
        redis.delete(userid);
        redis.delete(Constants.CURRENT_USER+"-"+userid);
    }
}
