package com.vcgo.Entity;

public class VcSysRolePoweritem extends BaseEntity{
    private static final long serialVersionUID = 1537701778813607720L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPoweritem_id() {
        return poweritem_id;
    }

    public void setPoweritem_id(Integer poweritem_id) {
        this.poweritem_id = poweritem_id;
    }

    private Integer id;

    private Integer role_id;

    private Integer poweritem_id;

    @Override
    public String toString() {
        return "VcSysRolePoweritem{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", poweritem_id=" + poweritem_id +
                '}';
    }
}