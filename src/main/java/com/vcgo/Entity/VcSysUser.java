package com.vcgo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VcSysUser extends BaseEntity{
    private static final long serialVersionUID = 2725171772591608894L;

    //region 用户本身属性
    private Integer id;
    private String aliasname;
    private String username;
    private String password;
    private Integer usertype;
    private Integer sex;
    private Date birthday;
    private Date lastlogindate;
    private String lastloginip;
    private Integer status;
    private Date createdate;
    private Integer sysorg_id;
    //endregion

    //region 角色相关
    private List<VcSysRole> roleList=new ArrayList<VcSysRole>();//拥有的角色列表
    private List<Integer> roleIds=new ArrayList<Integer>();//拥有的角色主键列表
    private String roleNames;//用户拥有的角色名称字符串
    private String roleIdsStr;//用户拥有的角色编码字符串
    //endregion

    public String getRoleIdsStr() {
        if(StringUtils.isEmpty(roleIdsStr)){
            roleIdsStr="";
            for (VcSysRole role:roleList
                    ) {
                roleIdsStr+=role.getId()+",";
            }
            roleIdsStr=roleIdsStr.endsWith(",")?roleIdsStr.substring(0,roleIdsStr.length()-1):roleIdsStr;
        }
        return roleIdsStr;
    }

    public void setRoleIdsStr(String roleIdsStr) {
        this.roleIdsStr = roleIdsStr;
    }

    public List<Integer> getRoleIds() {
        if(roleIds.size()<1){
            for (VcSysRole role:roleList
                 ) {
                roleIds.add(role.getId());
            }
        }
        return roleIds;
    }

    public String getRoleNames() {
        if(StringUtils.isEmpty(roleNames)){
            roleNames="";
            for (VcSysRole role:roleList
                 ) {
                roleNames+=role.getRolename()+",";
            }
            roleNames=roleNames.endsWith(",")?roleNames.substring(0,roleNames.length()-1):roleNames;
        }
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public List<VcSysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<VcSysRole> roleList) {
        this.roleList = roleList;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getAliasname() {
        return aliasname;
    }

    public void setAliasname(String aliasname) {
        this.aliasname = aliasname == null ? null : aliasname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }


    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getLastlogindate() {
        return lastlogindate;
    }

    public void setLastlogindate(Date lastlogindate) {
        this.lastlogindate = lastlogindate;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }
    public Integer getSysorg_id() {
        return sysorg_id;
    }

    public void setSysorg_id(Integer sysorg_id) {
        this.sysorg_id = sysorg_id;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "VcSysUser{" +
                "id=" + id +
                ", aliasname='" + aliasname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usertype=" + usertype +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", lastlogindate=" + lastlogindate +
                ", lastloginip='" + lastloginip + '\'' +
                ", status=" + status +
                ", createdate=" + createdate +
                ", sysorg_id=" + sysorg_id +
                '}';
    }
}