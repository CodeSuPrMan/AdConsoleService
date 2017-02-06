package com.vcgo.Entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 33469 on 2016/12/20.
 */

public  class JsonObj implements Serializable{

    private static final long serialVersionUID = 1822270493947149914L;

    public JsonObj(){
        System.out.println("json初始化");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private boolean success;
    private String message;
    private Object data;
    private  Integer recordCount;

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("JSON对象销毁");
    }
}
