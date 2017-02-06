package com.vcgo.Entity;

import java.util.List;

/**
 * Created by 33469 on 2017/2/1.
 */
public abstract class TreeEntity<T> extends BaseEntity {


    private Integer parentid;

    private List<T> children;

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
