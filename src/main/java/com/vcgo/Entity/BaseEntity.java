package com.vcgo.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 33469 on 2016/12/19.
 */
public abstract class BaseEntity implements Serializable {



    private Integer id;

    private Date createdate;

    private Date editdate;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getEditdate() {
        return editdate;
    }

    public void setEditdate(Date editdate) {
        this.editdate = editdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
