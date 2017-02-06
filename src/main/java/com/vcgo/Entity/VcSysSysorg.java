package com.vcgo.Entity;

import java.util.Date;

public class VcSysSysorg extends BaseEntity{
    private static final long serialVersionUID = 6334324013774496979L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    private Integer id;

    private Integer parentid;

    private Integer sysorgname;

    private Integer sysorgtype;

    private Date createdate;



    public Integer getSysorgname() {
        return sysorgname;
    }

    public void setSysorgname(Integer sysorgname) {
        this.sysorgname = sysorgname;
    }

    public Integer getSysorgtype() {
        return sysorgtype;
    }

    public void setSysorgtype(Integer sysorgtype) {
        this.sysorgtype = sysorgtype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "VcSysSysorg{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", sysorgname=" + sysorgname +
                ", sysorgtype=" + sysorgtype +
                ", createdate=" + createdate +
                '}';
    }
}