package com.vcgo.Entity;

import javax.validation.constraints.Null;

public class VcSysUserRole extends BaseEntity{
    private static final long serialVersionUID = -4464585467747540729L;
    private Integer id;
    private Integer user_id;
    private Integer role_id;


    public VcSysUserRole(){

    }
    public  VcSysUserRole(Integer user_id,Integer role_id){
        if(user_id!=null){
            setUser_id(user_id);
        }
        if(role_id!=null){
            setRole_id(role_id);
        }
    }



    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }



    @Override
    public String toString() {
        return "VcSysUserRole{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}