package com.vcgo.Entity;

import java.util.Date;
import java.util.List;

public class VcSysPoweritem  extends TreeEntity<VcSysPoweritem> {
    private static final long serialVersionUID = 1910072512442570814L;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    private String itemname;

    private String itemurl;

    private String itemtag;

    private String iconsclass;

    private String iconsopen;

    private String iconsclose;

    private String itemtype;

    public String getItemurl() {
        return itemurl;
    }

    public void setItemurl(String itemurl) {
        this.itemurl = itemurl == null ? null : itemurl.trim();
    }

    public String getItemtag() {
        return itemtag;
    }

    public void setItemtag(String itemtag) {
        this.itemtag = itemtag == null ? null : itemtag.trim();
    }

    public String getIconsclass() {
        return iconsclass;
    }

    public void setIconsclass(String iconsclass) {
        this.iconsclass = iconsclass == null ? null : iconsclass.trim();
    }

    public String getIconsopen() {
        return iconsopen;
    }

    public void setIconsopen(String iconsopen) {
        this.iconsopen = iconsopen == null ? null : iconsopen.trim();
    }

    public String getIconsclose() {
        return iconsclose;
    }

    public void setIconsclose(String iconsclose) {
        this.iconsclose = iconsclose == null ? null : iconsclose.trim();
    }


    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    @Override
    public String toString() {
        return "VcSysPoweritem{" +
                "id=" + super.getId() +
                ", parentid=" + super.getParentid() +
                ", itenname='" + itemname + '\'' +
                ", itemurl='" + itemurl + '\'' +
                ", itemtag='" + itemtag + '\'' +
                ", iconsclass='" + iconsclass + '\'' +
                ", iconsopen='" + iconsopen + '\'' +
                ", iconsclose='" + iconsclose + '\'' +
                ", createdate=" + super.getCreatedate() +
                ", itemtype=" + itemtype +
                '}';
    }
}