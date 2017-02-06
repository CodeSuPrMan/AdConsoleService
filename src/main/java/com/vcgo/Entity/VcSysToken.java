package com.vcgo.Entity;

/**
 * Created by 33469 on 2016/12/19.
 */
public class VcSysToken extends BaseEntity{
    private static final long serialVersionUID = 3638400927386759014L;

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private  long userid;

    private String token;

    public  VcSysToken(long userid,String token){
        this.token=token;
        this.userid=userid;
    }

    @Override
    public String toString() {
        return "VcSysToken{" +
                "userid=" + userid +
                ", token='" + token + '\'' +
                '}';
    }
}
