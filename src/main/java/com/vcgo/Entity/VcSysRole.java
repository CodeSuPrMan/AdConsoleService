package com.vcgo.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VcSysRole extends BaseEntity{
    private static final long serialVersionUID = -5631104330857303367L;

    //region 角色属性
    private Integer id;
    private String rolename;
    private String remark;
    private String rolecode;
    private Date createdate;
    //endregioni



    private List<Integer> poweritemids=new ArrayList<Integer>();//角色所拥有的权限Id列表
    private  List<VcSysPoweritem> rolepoweritems=new ArrayList<VcSysPoweritem>();//角色拥有的权限列表

    public List<VcSysPoweritem> getRolepoweritems() {
        return rolepoweritems;
    }
    public void setRolepoweritems(List<VcSysPoweritem> rolepoweritems) {
        this.rolepoweritems = rolepoweritems;
    }
    public List<Integer> getPoweritemids() {
        if(poweritemids.size()<1){
            for (VcSysPoweritem powerItem:rolepoweritems
                 ) {
                poweritemids.add(powerItem.getId());
            }
        }
        return poweritemids;
    }
    public void setPoweritemids(List<Integer> poweritemids) {
        this.poweritemids = poweritemids;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    public String getRolecode() {
        return rolecode;
    }
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }
    public Date getCreatedate() {
        return createdate;
    }
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    @Override
    public String toString() {
        return "VcSysRole{" +
                "id=" + id +
                ", rolename=" + rolename +
                ", remark='" + remark + '\'' +
                ", rolecode='" + rolecode + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}