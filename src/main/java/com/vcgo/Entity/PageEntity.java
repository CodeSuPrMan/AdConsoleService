package com.vcgo.Entity;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by 33469 on 2017/1/10.
 */
public class PageEntity<T>  extends  BaseEntity {


    private static final long serialVersionUID = -2006789109006945305L;

    private  Integer currentPage=0;
    private  Integer pageSize=20;
    private  Integer start;
    private  T paramEntity;
    private  String keyWord;
    private  Integer totalCount;
    private List<T> list;
    private  String orderField;

    public String getOrderField() {
        if(StringUtils.isEmpty(orderField)){
            return "CreateDate desc";
        }
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }





    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStart() {
       return   (currentPage-1)*pageSize;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public T getParamEntity() {
        return paramEntity;
    }

    public void setParamEntity(T paramEntity) {
        this.paramEntity = paramEntity;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", paramEntity=" + paramEntity +
                ", keyWord='" + keyWord + '\'' +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", orderField='" + orderField + '\'' +
                '}';
    }
}
